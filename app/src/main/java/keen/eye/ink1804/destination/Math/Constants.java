package keen.eye.ink1804.destination.Math;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class Constants {

    //настройки аккаунта
    public static final String APP_PREF = "app_settings";
    public static final String APP_PREF_NAME = "name"; // имя
    public static final String APP_PREF_DAY = "day"; // дата рождения
    public static final String APP_PREF_MONTH = "month"; // дата рождения
    public static final String APP_PREF_YEAR = "year"; // дата рождения
    public static final String APP_PREF_SEX = "sex"; // пол
    public static final String APP_PREF_STATUS = "status"; // статус пользователя
    public static final String APP_PREF_ISREGISTER = "isregister"; // наличие аккаунта
    public static final String APP_PREF_IMAGE = "icon";
    public static final String APP_PREF_SOCIONICS = "socionics_type";
    public static final String APP_PREF_NOTIFICATIONS = "doNotifications";

    public static final String APP_FIRST_LAUNCH = "first";

    //Годы по китайскому гороскопу
    public static final String[] TYPE_THINKING_NAMES = {"Логик","Волевик","Реалист","Мистик"};
    public static final String[] SYMBOL_FATE_NAMES = {"Пионерский знак","Фатальный знак","Знак Везения","Самодеятельный знак"};
    public static final String[] ENERGY_STRUCTURE_NAMES = {"Природный оптимист","Драмматизатор","Космический оптимист","Скептик"};
    public static final String[] MEANS_COMMUNICATE_NAMES = {"Открытый знак","Закрытый знак","Ортодокс"};
    public static final String[] PSYCHOLOGY_NAMES = {"Приземленный знак","Знак Возмужания","Взлетный знак", "Чувствительный знак"};
    public static final String[] ELEMENT_NAMES = {"Революционер (Огонь)","Консерватор (Вода)","Небожитель (Воздух)", "Созидатель (Земля)"};

    public static final String[] YEAR_NAMES =         {"Обезьяна","Петух", "Собака","Кабан",  "Крыса",   "Бык",   "Тигр","Кот",   "Дракон","Змея",    "Лошадь","Коза"};
    public static final String[] YEAR_HOST_NAMES =    {"Змея",    "Кот",   "Петух", "Лошадь", "Обезьяна","Собака","Бык", "Дракон","Кабан", "Коза",    "Крыса", "Тигр"};
    public static final String[] YEAR_SERVANT_NAMES = {"Крыса",   "Собака","Бык",   "Дракон", "Лошадь",  "Тигр",  "Коза","Петух", "Кот",   "Обезьяна","Кабан", "Змея"};
//    public static final String Y_SNAKE = "Змея";
//    public static final String Y_HORSE = "Лошадь";
//    public static final String Y_GOAT = "Коза";
//    public static final String Y_MONKEY = "Обезьяна";//id = 0
//    public static final String Y_COCK = "Петух";// id = 1
//    public static final String Y_DOG = "Собака";
//    public static final String Y_BOAR = "Кабан";
//    public static final String Y_RAT = "Крыса";
//    public static final String Y_BULL = "Бык";
//    public static final String Y_TIGER = "Тигр";
//    public static final String Y_CAT = "Кот";
//    public static final String Y_DRAGON = "Дракон";

    //Годовой период P_

    public static final String P_OVERCOMING= "Преодоление";
    public static final String P_DISCUISE = "Маскировка";
    public static final String P_EASE = "Легкость";
    public static final String P_PRESENTATION = "Презентация";

    //Знаки зодиака Z_

    public static final String[] ZODIAK_NAMES ={"Козерог","Водолей","Рыбы","Овен","Телец","Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец"};
    public static final String[] ZODIAK_NAMES_normal ={"Овен","Телец","Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец","Козерог","Водолей","Рыбы"};
//    public static final String Z_CAPRICORN = "Козерог";//id = 0
//    public static final String Z_AQUARIUS = "Водолей";
//    public static final String Z_FISH = "Рыбы";
//    public static final String Z_ARIES = "Овен";
//    public static final String Z_TAURUS = "Телец";
//    public static final String Z_TWINS = "Близнецы";
//    public static final String Z_CANCER = "Рак";
//    public static final String Z_LION = "Лев";
//    public static final String Z_VIRGO = "Дева";
//    public static final String Z_LIBRA = "Весы";
//    public static final String Z_SCORPION = "Скорпион";
//    public static final String Z_SAGITTARIUS = "Стрелец";

    public static final String[] VIRTUAL_NAMES = {"Рыцарь","Вождь","Король","Шут","Аристократ","Профессор","Вектор"};
    public static final String KNIGHT = "Рыцарь";
    public static final String LEADER = "Вождь";
    public static final String KING = "Король";
    public static final String CLOWN = "Шут";
    public static final String ARISTOCRAT = "Аристократ";
    public static final String PROFESSOR = "Профессор";
    public static final String VECTOR = "Вектор";

    public static final String[][][][] SOCIONICS = {{{{"Джек Лондон","Робеспьер"},{"Штирлиц","Максим Горький"}}
                                                    ,{{"Гамлет","Достоевский"},{"Гюго","Драйзер"}}}
                                                    ,{{{"Дон Кихот","Бальзак"},{"Жуков","Габен"}}
                                                    ,{{"Гексли","Есенин"},{"Наполеон","Дюма"}}}};

    public static final String[] SOCIONICS_NAMES = {"Джек Лондон","Штирлиц","Гамлет","Гюго","Робеспьер","Максим Горький",
            "Достоевский","Драйзер","Дон Кихот","Жуков","Гексли","Наполеон","Бальзак","Габен","Есенин","Дюма"};
}
