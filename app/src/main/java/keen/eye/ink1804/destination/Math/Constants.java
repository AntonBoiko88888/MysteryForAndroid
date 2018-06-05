package keen.eye.ink1804.destination.Math;

/**
 * Created by Ink1804 on 29.07.16.
 */
public final class Constants {

    //настройки аккаунта
    public static final String APP_PREF = "app_settings";
    public static final String APP_PREF_NAME = "name"; // имя
    public static final String APP_PREF_DAY = "day"; // дата рождения
    public static final String APP_PREF_MONTH = "month"; // дата рождения
    public static final String APP_PREF_YEAR = "year"; // дата рождения
    public static final String APP_PREF_SEX = "sex"; // пол
    public static final String APP_PREF_ISREGISTER = "isregister"; // наличие аккаунта
    public static final String APP_PREF_SOCIONICS = "socionics_type";
    public static final String APP_PREF_NOTIFICATIONS = "doNotifications";
    public static final String APP_PREF_TIME_NOTIFICATION = "timeNotification";
    public static final String APP_PREF_ZODIAC_NOTIFICATION = "zodiacNotification";


    //Годы по китайскому гороскопу
    static final String[] TYPE_THINKING_NAMES = {"Логик","Волевик","Реалист","Мистик"};
    static final String[] SYMBOL_FATE_NAMES = {"Пионерский знак","Фатальный знак","Знак Везения","Самодеятельный знак"};
    static final String[] ENERGY_STRUCTURE_NAMES = {"Природный оптимист","Драмматизатор","Космический оптимист","Скептик"};
    static final String[] MEANS_COMMUNICATE_NAMES = {"Открытый знак","Закрытый знак","Ортодокс"};
    static final String[] PSYCHOLOGY_NAMES = {"Приземленный знак","Знак Возмужания","Взлетный знак", "Чувствительный знак"};
    static final String[] ELEMENT_NAMES = {"Революционер (Огонь)","Консерватор (Вода)","Небожитель (Воздух)", "Созидатель (Земля)"};

    public static final String[] YEAR_NAMES =  {"Обезьяна","Петух", "Собака","Кабан",  "Крыса",   "Бык",   "Тигр","Кот",   "Дракон","Змея",    "Лошадь","Коза"};
    static final String[] YEAR_HOST_NAMES =    {"Змея",    "Кот",   "Петух", "Лошадь", "Обезьяна","Собака","Бык", "Дракон","Кабан", "Коза",    "Крыса", "Тигр"};
    static final String[] YEAR_SERVANT_NAMES = {"Крыса",   "Собака","Бык",   "Дракон", "Лошадь",  "Тигр",  "Коза","Петух", "Кот",   "Обезьяна","Кабан", "Змея"};


    //Годовой период P_

    static final String P_OVERCOMING= "Преодоление";
    static final String P_DISCUISE = "Маскировка";
    static final String P_EASE = "Легкость";
    static final String P_PRESENTATION = "Презентация";

    //Знаки зодиака Z_

    public static final String[] ZODIAK_NAMES ={"Козерог","Водолей","Рыбы","Овен","Телец","Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец"};
    public static final String[] ZODIAK_NAMES_normal ={"Овен","Телец","Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец","Козерог","Водолей","Рыбы"};

    public static final String[] VIRTUAL_NAMES = {"Рыцарь","Вождь","Король","Шут","Аристократ","Профессор","Вектор"};
    static final String KNIGHT = "Рыцарь";
    static final String LEADER = "Вождь";
    static final String KING = "Король";
    static final String CLOWN = "Шут";
    static final String ARISTOCRAT = "Аристократ";
    static final String PROFESSOR = "Профессор";
    static final String VECTOR = "Вектор";

    public static final String[][][][] SOCIONICS = {{{{"Джек Лондон","Робеспьер"},{"Штирлиц","Максим Горький"}}
                                                    ,{{"Гамлет","Достоевский"},{"Гюго","Драйзер"}}}
                                                    ,{{{"Дон Кихот","Бальзак"},{"Жуков","Габен"}}
                                                    ,{{"Гексли","Есенин"},{"Наполеон","Дюма"}}}};

    public static final String[] SOCIONICS_NAMES = {"Джек Лондон","Робеспьер","Штирлиц","Максим Горький",
            "Гамлет","Достоевский","Гюго","Драйзер","Дон Кихот","Бальзак","Жуков","Габен","Гексли","Есенин","Наполеон","Дюма"};
}


//TODO Все активности на разные лэйауты
//TODO Один дравер с handler на активности
//TODO переименовать все классы и названия сделать человеческие
//TODO HTML Parser переделать
//TODO шрифты в либу
//TODO диалоговое окно в отдельный класс
//TODO инстансы фрагментов
//TODO sharedpref mb to realm
//TODO убрать TTL
//TODO убрать ion на volley
//TODO ВСЕЕЕЕЕЕ константы перенести, абсолютно все
//TODO app localization (перевести приложение)
//TODO Design to remade - material design
// TODO watch app :)
//TODO угнать приложение
//TODO история гороскопов
//TODO appIntro переделать
//TODO temp profile переделать
//TODO DRAWERLAYOUT переделать сРОЧНАААА
//TODO callbacks to redo with custom alert box
//TODO service который постоянно проверяет интернет
//TODO сервис с нотификациями
//TODO textviews нормально сделать
//TODO constants использовать
// TODO Online horoscope to recyclerview with grid manager (может)
//TODO intresting activity listView create
//TODO pagerstrip наверно убрать что ли
//TODO layout несколько разных размеров  - мб


