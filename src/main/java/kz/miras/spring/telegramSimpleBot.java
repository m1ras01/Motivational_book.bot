package kz.miras.spring;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
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
            } else if (command.equals("Выбрать")) {
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
            } else if (data.equals("Закон успеха")) {
                zakonUspeha(chatId.toString());
            } else if (data.equals("Думай и богатей MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C://Users//Алекс//Documents//Russian Language 2.0//motivational books//Наполеон Хилл//AUDIO//Думай и богатей.mp3","Думай и богатей","Наполеон Хилл");
            } else if (data.equals("Думай и богатей PDF")) {
                sendPdfToUser(chatId.toString(), "C://Users//Алекс//Documents//Russian Language 2.0//motivational books//Наполеон Хилл//PDF//Думай и богатей.pdf");
            } else if (data.equals("Закон успеха PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Наполеон Хилл/PDF/Закон успеха.pdf");
            } else if (data.equals("Закон успеха MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Наполеон Хилл/AUDIO/закон успеха.mp3","Закон успеха","Наполеон Хилл");
            } else if (data.equals("Барбара Шер")) {
                BarbaraSher(chatId.toString());
            } else if (data.equals("Мечтать не вредно")) {
                MechtatNeVredno(chatId.toString());
            } else if (data.equals("Мечтать не вредно PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Барбара Шер/PDF/Мечтать не вредно.pdf");
            } else if (data.equals("Мечтать не вредно MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Барбара Шер/AUDIO/Мечтать не вредно.mp3","Мечтать не вредно","Барбара Шер");
            } else if (data.equals("Тони")) {
                ToniRobbins(chatId.toString());
            }
            else if (data.equals("Разбуди в себе исполина")){
                RazbudySebeIspolyna(chatId.toString());
            } else if (data.equals("Разбуди в себе исполина PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Тони Руббинс/ЭнтониРоббинс_Разбуде_В_Себе_Исполина.pdf");
            } else if (data.equals("Разбуди в себе исполина MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Тони Руббинс/Разбуди в себе исполина.mp3","Разбуди в себе исполина","Тони Руббинс");
            } else if (data.equals("Деньги Мастер игры")) {
                DengiMasterIgry(chatId.toString());
            } else if (data.equals("Деньги Мастер игры PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Тони Руббинс/ЭнтониРоббинс_Деньги_Мастер_игры.pdf");
            } else if (data.equals("Деньги Мастер игры MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Тони Руббинс/Деньги. Мастер игры.mp3","Деньги. Мастер игры","Тони Руббинс");
            } 
            
              
              else if (data.equals("Дейл Карнеги")) {
                DeilKarnegy(chatId.toString());
            } else if (data.equals("Как перестать беспокоиться PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Дейл Карнеги/PDF/D_karnegi-kak_perestat_bespokoitsya-i-nachat-zhit.pdf");
            } else if (data.equals("Как перестать беспокоиться MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C://Users//Алекс//Documents//Russian Language 2.0//motivational books//Дейл Карнеги//MP3//23295.mp3","Как перестать беспокоиться","Дейл Карнеги");
            } else if (data.equals("Как завоевывать друзей PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Дейл Карнеги/PDF/Karnegi_D._Kak_Zavoevyivat_Druzeyi_I.a4.pdf");
            } else if (data.equals("Как завоевывать друзей MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C://Users//Алекс//Documents//Russian Language 2.0//motivational books//Дейл Карнеги//MP3//48853.mp3","Как завоевывать друзей","Дейл Карнеги");
            } else if (data.equals("Как завоевывать друзей")) {
                KakZavoevatDruzei(chatId.toString());
            } else if (data.equals("Как перестать беспокоиться")) {
                KakPerestatBespokoytsiya(chatId.toString());
            } 
            
              
              else if (data.equals("Брайан Трейси")) {
                BrainTraincy(chatId.toString());
            } else if (data.equals("Сила уверенности в себе")) {
                SylaUverrennosryVSebe(chatId.toString());
            } else if (data.equals("Сила уверенности в себе PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/PDF/Сила уверенности в себе. Брайан Трейси.pdf");
            } else if (data.equals("Сила уверенности в себе MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/MP3/Сила уверенности в себе.mp3","Сила уверенности в себе", "Брайан Трейси");
            } else if (data.equals("Нет оправданий")) {
                NetOpravdany(chatId.toString());
            } else if (data.equals("Нет оправданий PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/PDF/Нет оправданий! Сила самодисциплины. Брайан Трейси..pdf");
            } else if (data.equals("Нет оправданий MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/MP3/Нет оправданий.mp3","Нет оправданий","Брайан Трейси");
            } else if (data.equals("Мастер времени")) {
                MasterVremeni(chatId.toString());
            } else if (data.equals("Мастер времени PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/PDF/Мастер времени. Брайан Трейси.pdf");
            } else if (data.equals("Мастер времени MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/MP3/Мастер времени.mp3","Мастер времени","Брайан Трейси");
            }



              else if (data.equals("Стивен Кови")) {
                StevinKovin(chatId.toString());
            } else if (data.equals("навыков высокоэффективных людей")) {
                efficent7(chatId.toString());
            } else if (data.equals("навыков высокоэффективных людей PDF")) {
                sendPdfToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Стивен Кови/PDF/7 навыков высокоэффективных людей СтивенКови.pdf");
            } else if (data.equals("навыков высокоэффективных людей MP3")) {
                sendLocalAudioToUser(chatId.toString(),"C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Стивен Кови/MP3/47584.mp3","7 навыков высокоэффективных людей","Стивен Кови");
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void chooseAuthor(String chatId){
        sendPhoto(chatId.toString(), new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/photo_2024-02-12_20-01-34.jpg"));

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
        keyboardButton.setText("Выбрать");
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

        sendPhoto(chatId.toString(),new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/chooseAuthor.jpg"));
        sendMessage.setText("Выбрать автор");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList4 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList5 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList6 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList7 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList8 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList9 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList10 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton10 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Наполеон Хилл");
        inlineKeyboardButton2.setText("Барбара Шер");
        inlineKeyboardButton3.setText("Тони Роббинс");
        inlineKeyboardButton4.setText("Дейл Карнеги");
        inlineKeyboardButton5.setText("Брайан Трейси");
        inlineKeyboardButton6.setText("Стивен Кови");

        inlineKeyboardButton1.setCallbackData("Наполеон Хилл");
        inlineKeyboardButton2.setCallbackData("Барбара Шер");
        inlineKeyboardButton3.setCallbackData("Тони");
        inlineKeyboardButton4.setCallbackData("Дейл Карнеги");
        inlineKeyboardButton5.setCallbackData("Брайан Трейси");
        inlineKeyboardButton6.setCallbackData("Стивен Кови");

        inlineKeyboardButtonList1.add(inlineKeyboardButton1);
        inlineKeyboardButtonList2.add(inlineKeyboardButton2);
        inlineKeyboardButtonList3.add(inlineKeyboardButton3);
        inlineKeyboardButtonList4.add(inlineKeyboardButton4);
        inlineKeyboardButtonList5.add(inlineKeyboardButton5);
        inlineKeyboardButtonList6.add(inlineKeyboardButton6);

        inlineButtons.add(inlineKeyboardButtonList1);
        inlineButtons.add(inlineKeyboardButtonList2);
        inlineButtons.add(inlineKeyboardButtonList3);
        inlineButtons.add(inlineKeyboardButtonList4);
        inlineButtons.add(inlineKeyboardButtonList5);
        inlineButtons.add(inlineKeyboardButtonList6);
       // inlineButtons.add(inlineKeyboardButtonList3);

        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void StevinKovin(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendPhoto(chatId.toString(),new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Стивен Кови/3-2.jpeg"));


        sendMessage.setText("Выбрать книгу Стивен Кови");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("навыков высокоэффективных людей");


        inlineKeyboardButton1.setCallbackData("навыков высокоэффективных людей");


        inlineKeyboardButtonList1.add(inlineKeyboardButton1);

        inlineButtons.add(inlineKeyboardButtonList1);


        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void efficent7(String chatId){
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


        inlineKeyboardButton1.setCallbackData("навыков высокоэффективных людей MP3");
        inlineKeyboardButton2.setCallbackData("навыков высокоэффективных людей PDF");


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

    public void BrainTraincy(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        sendPhoto(chatId.toString(),new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Брайан Трейси/BTracy_current2015-20161201-113908.jpg"));
        sendMessage.setText("Выбрать книгу Брайан Трейси");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Мастер времени");
        inlineKeyboardButton2.setText("Нет оправданий");
        inlineKeyboardButton3.setText("Сила уверенности в себе");


        inlineKeyboardButton1.setCallbackData("Мастер времени");
        inlineKeyboardButton2.setCallbackData("Нет оправданий");
        inlineKeyboardButton3.setCallbackData("Сила уверенности в себе");


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

    public void MasterVremeni(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Мастер времени MP3");
        inlineKeyboardButton2.setCallbackData("Мастер времени PDF");


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

    public void NetOpravdany(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Нет оправданий MP3");
        inlineKeyboardButton2.setCallbackData("Нет оправданий PDF");


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
    public void SylaUverrennosryVSebe(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Сила уверенности в себе MP3");
        inlineKeyboardButton2.setCallbackData("Сила уверенности в себе PDF");


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


    public void DeilKarnegy(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        sendPhoto(chatId.toString(), new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Дейл Карнеги/97ac38fdb02f7e87a9a1f3811c040bb7--dale-carnegie-stepping-stones.jpg"));
        sendMessage.setText("Выбрать книгу Дейл Карнеги");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Как завоевывать друзей");
        inlineKeyboardButton2.setText("Как перестать беспокоиться");


        inlineKeyboardButton1.setCallbackData("Как завоевывать друзей");
        inlineKeyboardButton2.setCallbackData("Как перестать беспокоиться");


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

    public void KakZavoevatDruzei(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Как завоевывать друзей MP3");
        inlineKeyboardButton2.setCallbackData("Как завоевывать друзей PDF");


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

    public void KakPerestatBespokoytsiya(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Как перестать беспокоиться MP3");
        inlineKeyboardButton2.setCallbackData("Как перестать беспокоиться PDF");


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

    public void ToniRobbins(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        sendPhoto(chatId.toString(),new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Тони Руббинс/7596769b76c7cfbf27c0f547dfbd5353.jpg"));
        sendMessage.setText("Выбрать книгу Тони Руббинс");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Разбуди в себе исполина");
        inlineKeyboardButton2.setText("Деньги Мастер игры");


        inlineKeyboardButton1.setCallbackData("Разбуди в себе исполина");
        inlineKeyboardButton2.setCallbackData("Деньги Мастер игры");


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

    public void DengiMasterIgry(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Деньги Мастер игры MP3");
        inlineKeyboardButton2.setCallbackData("Деньги Мастер игры PDF");


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

    public void RazbudySebeIspolyna(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Разбуди в себе исполина MP3");
        inlineKeyboardButton2.setCallbackData("Разбуди в себе исполина PDF");


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

    public void BarbaraSher(String chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        sendPhoto(chatId.toString(),new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Барбара Шер/nrjd8V5oswzM3sKfYAEq0Q.jpg"));
        sendMessage.setText("Выбрать книгу Барбара Шер");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Мечтать не вредно");


        inlineKeyboardButton1.setCallbackData("Мечтать не вредно");


        inlineKeyboardButtonList1.add(inlineKeyboardButton1);

        inlineButtons.add(inlineKeyboardButtonList1);


        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void MechtatNeVredno(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Мечтать не вредно MP3");
        inlineKeyboardButton2.setCallbackData("Мечтать не вредно PDF");


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


public void NapaleonHiil(String chatId){
    SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(chatId);

    sendPhoto(chatId.toString(), new File("C:/Users/Алекс/Documents/Russian Language 2.0/motivational books/Наполеон Хилл/MV5BYjViZjUwMjctODAyNy00Yjc3LTkwOWYtOTJhODg1Yzk1NDQ3XkEyXkFqcGdeQXVyMjA2NDEwMjg@._V1_.jpg"));

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
//        inlineKeyboardButton2.setText("Как стать богатым за один год");
    inlineKeyboardButton3.setText("Закон успеха");

    inlineKeyboardButton1.setCallbackData("Думай и богатей");
//        inlineKeyboardButton2.setCallbackData("Как стать богатым за один год");
    inlineKeyboardButton3.setCallbackData("Закон успеха");

    inlineKeyboardButtonList1.add(inlineKeyboardButton1);
//        inlineKeyboardButtonList2.add(inlineKeyboardButton2);
    inlineKeyboardButtonList3.add(inlineKeyboardButton3);
    inlineButtons.add(inlineKeyboardButtonList1);
    //    inlineButtons.add(inlineKeyboardButtonList2);
    inlineButtons.add(inlineKeyboardButtonList3);

    inlineKeyboardMarkup.setKeyboard(inlineButtons);
    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    try {
        execute(sendMessage);
    } catch (TelegramApiException e) {
        throw new RuntimeException(e);
    }
}

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

    public void zakonUspeha(String chatId){
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


        inlineKeyboardButton1.setCallbackData("Закон успеха MP3");
        inlineKeyboardButton2.setCallbackData("Закон успеха PDF");


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
    public void sendPhoto(String chatId, File photoFilePath) {
        // Создаем объект SendPhoto
        SendPhoto sendPhoto = new SendPhoto();
        // Устанавливаем идентификатор чата, куда будет отправлена фотография
        sendPhoto.setChatId(chatId);

        // Создаем объект InputFile и передаем в него файл с фотографией
        InputFile photo = new InputFile(photoFilePath);
        // Устанавливаем фотографию для отправки
        sendPhoto.setPhoto(photo);

        try {
            // Отправляем фотографию
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            System.out.println("Ошибка при отправке фотографии: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
