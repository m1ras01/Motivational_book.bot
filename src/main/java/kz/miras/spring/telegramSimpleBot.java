package kz.miras.spring;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class telegramSimpleBot extends TelegramLongPollingBot {
    InputFile audioFile = new InputFile("https://github.com/m1ras01/musics/raw/main/%D0%94%D0%BE%D0%BC%2050%20_%20Mashup.mp3");
    String title = "Название аудио";
    String performer = "Исполнитель";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (command.equals("/start")) {
                chooseAuthor(String.valueOf(chatId));
            } else if (command.equals("Choose")) {
                ListAuthors(String.valueOf(chatId));
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            Long chatId = callbackQuery.getMessage().getChatId();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId.toString());

            if (data.equals("Наполеон Хилл")) {
                NapaleonHiil(chatId.toString());
            }else if (data.equals("Думай и богатей")) {
                dumaiBogatei(chatId.toString());
            } else if (data.equals("Думай и богатей MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Downloads/Telegram Desktop/Дом 50 _ Mashup.mp3","sffdsf","afd");
            } else if (data.equals("Думай и богатей PDF")) {
                sendPdfToUser(chatId.toString(), "C:/Users/Алекс/Downloads/Lab 7.pdf");

            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void chooseAuthor(String chatId){
        String startMessage = "Приветствую тебя! Я твой личный библиотекарь \uD83D\uDCDA✨\n" +
                "\n" +
                "Я здесь, чтобы помочь тебе насладиться замечательными книгами, предоставляя доступ к аудиокнигам и книгам в формате PDF. Просто отправь мне название книги или выбери из списка доступных опций, и я сделаю все возможное, чтобы удовлетворить твои чтению и прослушиванию. \n" +
                "\n" +
                "Приятного чтения и прослушивания! \uD83D\uDCD6\uD83C\uDFA7\n" +
                "\n" +
                "Выбери автор\uD83D\uDC68\u200D\uD83D\uDCBC";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(startMessage);
        sendMessage.setChatId(chatId);


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Choose");
        //keyboardButton.setRequestLocation(true);
        keyboardRow.add(keyboardButton);
        keyboardRowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            System.out.println("Choose author"+e);
        }
    }


    public void ListAuthors(String chatId){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        sendMessage.setText("Выбрать автор");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Наполеон Хилл");
        inlineKeyboardButton2.setText("Джим Рон");
        inlineKeyboardButton3.setText("Джордж Самюэль");

        inlineKeyboardButton1.setCallbackData("Наполеон Хилл");
        inlineKeyboardButton2.setCallbackData("Джим Рон");
        inlineKeyboardButton3.setCallbackData("Джордж Самюэль");

        inlineKeyboardButtonList1.add(inlineKeyboardButton1);
        inlineKeyboardButtonList2.add(inlineKeyboardButton2);
        inlineKeyboardButtonList3.add(inlineKeyboardButton3);
        inlineButtons.add(inlineKeyboardButtonList1);
        inlineButtons.add(inlineKeyboardButtonList2);
        inlineButtons.add(inlineKeyboardButtonList3);

        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


    public void sendAudioToUser(String chatId, InputFile audioFile, String title, String performer) {
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(chatId);
        sendAudio.setAudio(audioFile);
        sendAudio.setTitle(title);
        sendAudio.setPerformer(performer);
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        KeyboardRow keyboardRow = new KeyboardRow();
//        keyboardRow.add("Выбери автор");
//        replyKeyboardMarkup.setKeyboard(List.of(keyboardRow)); // Помещаем кнопку в клавиатуру
//        keyboardRow.add("Поделиться");
//        replyKeyboardMarkup.setKeyboard(List.of(keyboardRow)); // Помещаем кнопку в клавиатуру
//        sendAudio.setReplyMarkup(replyKeyboardMarkup); // Устанавливаем клавиатуру в сообщении
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            System.err.println("Ошибка отправки аудио: " + e.getMessage());
        }

    }

    public void NapaleonHiil(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);


        sendMessage.setText("Выбрать книгу Наполеон Хилл");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Думай и богатей");
        inlineKeyboardButton2.setText("Как стать богатым за один год");
        inlineKeyboardButton3.setText("Закон успеха");

        inlineKeyboardButton1.setCallbackData("Думай и богатей");
        inlineKeyboardButton2.setCallbackData("Как стать богатым за один год");
        inlineKeyboardButton3.setCallbackData("Закон успеха");

        inlineKeyboardButtonList1.add(inlineKeyboardButton1);
        inlineKeyboardButtonList2.add(inlineKeyboardButton2);
        inlineKeyboardButtonList3.add(inlineKeyboardButton3);
        inlineButtons.add(inlineKeyboardButtonList1);
        inlineButtons.add(inlineKeyboardButtonList2);
        inlineButtons.add(inlineKeyboardButtonList3);

        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
//    public void DjimRon(String chatId){
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chatId);
//
//        sendMessage.setText("Выбрать книгу");
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
//        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
//        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
//        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
//
//        inlineKeyboardButton1.setText("Думай и богатей");
//        inlineKeyboardButton2.setText("Как стать богатым за один год");
//        inlineKeyboardButton3.setText("Закон успеха");
//
//        inlineKeyboardButton1.setCallbackData("Наполеон Хилл");
//        inlineKeyboardButton2.setCallbackData("Джим Рон");
//        inlineKeyboardButton3.setCallbackData("Джордж Самюэль");
//
//        inlineKeyboardButtonList1.add(inlineKeyboardButton1);
//        inlineKeyboardButtonList2.add(inlineKeyboardButton2);
//        inlineKeyboardButtonList3.add(inlineKeyboardButton3);
//        inlineButtons.add(inlineKeyboardButtonList1);
//        inlineButtons.add(inlineKeyboardButtonList2);
//        inlineButtons.add(inlineKeyboardButtonList3);
//
//        inlineKeyboardMarkup.setKeyboard(inlineButtons);
//        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void DjorddjSamuel(String chatId){
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chatId);
//
//        sendMessage.setText("Выбрать книгу");
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
//        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
//        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
//        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
//
//        inlineKeyboardButton1.setText("Наполеон Хилл");
//        inlineKeyboardButton2.setText("Джим Рон");
//        inlineKeyboardButton3.setText("Джордж Самюэль");
//
//        inlineKeyboardButton1.setCallbackData("Наполеон Хилл");
//        inlineKeyboardButton2.setCallbackData("Джим Рон");
//        inlineKeyboardButton3.setCallbackData("Джордж Самюэль");
//
//        inlineKeyboardButtonList1.add(inlineKeyboardButton1);
//        inlineKeyboardButtonList2.add(inlineKeyboardButton2);
//        inlineKeyboardButtonList3.add(inlineKeyboardButton3);
//        inlineButtons.add(inlineKeyboardButtonList1);
//        inlineButtons.add(inlineKeyboardButtonList2);
//        inlineButtons.add(inlineKeyboardButtonList3);
//
//        inlineKeyboardMarkup.setKeyboard(inlineButtons);
//        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public void dumaiBogatei(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);


        sendMessage.setText("MP3 или PDF");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();


        inlineKeyboardButton1.setText("MP3");
        inlineKeyboardButton2.setText("PDF");


        inlineKeyboardButton1.setCallbackData("Думай и богатей MP3");
        inlineKeyboardButton2.setCallbackData("Думай и богатей PDF");


        inlineKeyboardButtonList1.add(inlineKeyboardButton1);
        inlineKeyboardButtonList2.add(inlineKeyboardButton2);

        inlineButtons.add(inlineKeyboardButtonList1);
        inlineButtons.add(inlineKeyboardButtonList2);


        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    // метод для отправки PDF файла
    public void sendPdfToUser(String chatId, String filePath) {
        InputFile pdfFile = new InputFile(new File(filePath));
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(pdfFile);

        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            System.err.println("Ошибка отправки документа: " + e.getMessage());
        }
    }
    public void sendLocalAudioToUser(String chatId, String filePath, String title, String performer) {
        InputFile audioFile = new InputFile(new File(filePath));
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(chatId);
        sendAudio.setAudio(audioFile);
        sendAudio.setTitle(title);
        sendAudio.setPerformer(performer);

        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            System.err.println("Ошибка отправки аудиофайла: " + e.getMessage());
        }
    }
    @Override
    public String getBotUsername() {
        return "aitu_library_bot";
    }

    @Override
    public String getBotToken() {
        return "6370474144:AAFyUcKmgWlVBLCOQDncmsMCgLpzU1AN2Kw";
    }
    public void sendMessage(long chatId,String textToSend) throws Exception{
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        }catch (TelegramApiException e){
            System.out.println(e);
        }

    }
}
