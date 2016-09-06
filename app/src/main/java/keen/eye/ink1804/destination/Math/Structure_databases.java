package keen.eye.ink1804.destination.Math;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class Structure_databases {
    static Constants C = new Constants();
    public static final String[][] StructureHorADMIN = {
            {C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN},//обезьяна
            {C.KING, C.KING + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING},//петух
            {C.VECTOR, C.VECTOR + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.VECTOR},//собака
            {C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT},//кабан
            {C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.ARISTOCRAT},//крыса
            {C.PROFESSOR, C.PROFESSOR + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR},//бык
            {C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.LEADER},//тигр
            {C.VECTOR, C.VECTOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.VECTOR},//кот
            {C.LEADER, C.LEADER + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER},//дракон
            {C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.VECTOR, C.VECTOR, C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.PROFESSOR},//змея
            {C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.VECTOR, C.VECTOR, C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT, C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT},//лошадь
            {C.KNIGHT, C.KNIGHT + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.LEADER, C.LEADER, C.LEADER + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.PROFESSOR, C.PROFESSOR, C.PROFESSOR + "+" + C.ARISTOCRAT, C.ARISTOCRAT, C.ARISTOCRAT + "+" + C.VECTOR, C.VECTOR, C.VECTOR + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KING, C.KING, C.KING + "+" + C.CLOWN, C.CLOWN, C.CLOWN + "+" + C.KNIGHT},//коза
    };
    public static final String[][] StructureHor = {
            {C.CLOWN, C.KNIGHT, C.ARISTOCRAT, C.VECTOR, C.LEADER, C.ARISTOCRAT, C.LEADER, C.PROFESSOR, C.VECTOR, C.KNIGHT, C.CLOWN, C.KING},//обезьяна
            {C.KING, C.VECTOR, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.LEADER, C.VECTOR, C.LEADER, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT, C.CLOWN},//петух
            {C.VECTOR, C.KING, C.CLOWN, C.KNIGHT, C.VECTOR, C.PROFESSOR, C.LEADER, C.ARISTOCRAT, C.LEADER, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT},//собака
            {C.KNIGHT, C.CLOWN, C.KING, C.CLOWN, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.VECTOR, C.ARISTOCRAT, C.VECTOR, C.PROFESSOR, C.ARISTOCRAT},//кабан
            {C.ARISTOCRAT, C.KNIGHT, C.CLOWN, C.KING, C.CLOWN, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.LEADER, C.VECTOR, C.LEADER, C.VECTOR},//крыса
            {C.PROFESSOR, C.VECTOR, C.KNIGHT, C.CLOWN, C.KING, C.VECTOR, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.LEADER, C.ARISTOCRAT, C.LEADER},//бык
            {C.LEADER, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT, C.VECTOR, C.KING, C.CLOWN, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.VECTOR, C.ARISTOCRAT},//тигр
            {C.VECTOR, C.LEADER, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT, C.CLOWN, C.KING, C.VECTOR, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.LEADER},//кот
            {C.LEADER, C.ARISTOCRAT, C.VECTOR, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT, C.VECTOR, C.KING, C.CLOWN, C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR},//дракон
            {C.PROFESSOR, C.LEADER, C.ARISTOCRAT, C.LEADER, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT, C.CLOWN, C.KING, C.CLOWN, C.VECTOR, C.VECTOR, C.VECTOR,},//змея
            {C.ARISTOCRAT, C.PROFESSOR, C.VECTOR, C.VECTOR, C.VECTOR, C.LEADER, C.PROFESSOR, C.ARISTOCRAT, C.KNIGHT, C.CLOWN, C.KING, C.CLOWN, C.KNIGHT,},//лошадь
            {C.KNIGHT, C.ARISTOCRAT, C.PROFESSOR, C.LEADER, C.ARISTOCRAT, C.VECTOR, C.PROFESSOR, C.ARISTOCRAT, C.VECTOR, C.CLOWN, C.KING, C.CLOWN},//коза
    };
    public static final String[][] YearPeriod = {
            {C.P_PRESENTATION, C.P_OVERCOMING, C.P_DISCUISE, C.P_EASE},//Логики
            {C.P_EASE, C.P_PRESENTATION, C.P_OVERCOMING, C.P_DISCUISE},//Волевики
            {C.P_DISCUISE, C.P_EASE, C.P_PRESENTATION, C.P_OVERCOMING},//Реалисты
            {C.P_OVERCOMING, C.P_DISCUISE, C.P_EASE, C.P_PRESENTATION},//Мистики
    };

    public int getDateIdAdmin(int day, int month) {
        int res = -1;
        switch (month) {
            case 1:
                if (day <= 16) res = 0;
                else if (day >= 17 && day <= 27) res = 1;
                else if (day >= 28 && day <= 31) res = 2;
                break;
            case 2:
                if (day <= 15) res = 2;
                else if (day >= 16 && day <= 26) res = 3;
                else if (day >= 27 && day <= 29) res = 4;
                break;
            case 3:
                if (day <= 17) res = 4;
                else if (day >= 18 && day <= 28) res = 5;
                else if (day >= 29 && day <= 31) res = 6;
                break;
            case 4:
                if (day <= 16) res = 6;
                else if (day >= 17 && day <= 27) res = 7;
                else if (day >= 28 && day <= 30) res = 8;
                break;
            case 5:
                if (day <= 17) res = 8;
                else if (day >= 18 && day <= 28) res = 9;
                else if (day >= 29 && day <= 31) res = 10;
                break;
            case 6:
                if (day <= 16) res = 10;
                else if (day >= 17 && day <= 27) res = 11;
                else if (day >= 28 && day <= 30) res = 12;
                break;
            case 7:
                if (day <= 17) res = 12;
                else if (day >= 18 && day <= 28) res = 13;
                else if (day >= 29 && day <= 31) res = 14;
                break;
            case 8:
                if (day <= 16) res = 14;
                else if (day >= 17 && day <= 27) res = 15;
                else if (day >= 28 && day <= 31) res = 16;
                break;
            case 9:
                if (day <= 16) res = 16;
                else if (day >= 17 && day <= 27) res = 17;
                else if (day >= 28 && day <= 30) res = 18;
                break;
            case 10:
                if (day <= 16) res = 18;
                else if (day >= 17 && day <= 27) res = 19;
                else if (day >= 28 && day <= 31) res = 20;
                break;
            case 11:
                if (day <= 16) res = 20;
                else if (day >= 17 && day <= 27) res = 21;
                else if (day >= 28 && day <= 30) res = 22;
                break;
            case 12:
                if (day <= 16) res = 22;
                else if (day >= 17 && day <= 26) res = 23;
                else if (day >= 27 && day <= 31) res = 0;
                break;
            default:
                break;
        }
        return res;
    }//done

    public int getDateId(int day, int month) {
        int res = -1;
        switch (month) {
            case 1:
                if (day <= 21) res = 0;
                else res = 1;
                break;
            case 2:
                if (day <= 20) res = 1;
                else res = 2;
                break;
            case 3:
                if (day <= 22) res = 2;
                else res = 3;
                break;
            case 4:
                if (day <= 21) res = 3;
                else res = 4;
                break;
            case 5:
                if (day <= 22) res = 4;
                else res = 5;
                break;
            case 6:
                if (day <= 21) res = 5;
                else res = 6;
                break;
            case 7:
                if (day <= 22) res = 6;
                else res = 7;
                break;
            case 8:
                if (day <= 21) res = 7;
                else res = 8;
                break;
            case 9:
                if (day <= 21) res = 8;
                else res = 9;
                break;
            case 10:
                if (day <= 21) res = 9;
                else res = 10;
                break;
            case 11:
                if (day <= 21) res = 10;
                else res = 11;
                break;
            case 12:
                if (day <= 21) res = 11;
                else res = 0;
                break;
            default:
                break;
        }
        return res;
    }//done

    public int getYearId(int year) {
        return year % 12;
    }//done

    public String getYearName(int year) {
        String yearName = "";
        yearName = C.YEAR_NAMES[year % 12];
        return yearName;
    }//done

    public String getNumberYear(int yearNow, int month, int day) { // Возвращает число года
        int numberYear = 0;
        numberYear = yearNow + month + day;
        numberYear = SummChislo(numberYear);
        return String.valueOf(numberYear);
    }//done

    public int SummChislo(int Chislo) { // Суммирует каждую цифру числа
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += Chislo % 10;
            Chislo = Chislo / 10;
        }
        if (res > 9) res = SummChislo(res);
        return res;
    }//done

    public String getEqualMarriageName(int year) {
        String res = "";
        switch (year) {
            case 0:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 1:
                res = C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 2:
                res = C.YEAR_NAMES[9];
                break;
            case 3:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4];
                break;
            case 4:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 5:
                res = C.YEAR_NAMES[10];
                break;
            case 6:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[9];
                break;
            case 7:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4];
                break;
            case 8:
                res = C.YEAR_NAMES[11];
                break;
            case 9:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 10:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 11:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
        }
        return res;
    }//done

    public String getRomanticMarriageName(int year) {
        String res = "";
        switch (year) {
            case 0:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 1:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[11];
                break;
            case 2:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 3:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 4:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6];
                break;
            case 5:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 6:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 7:
                res = C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 8:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 9:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7];
                break;
            case 10:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[8];
                break;
            case 11:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5];
                break;
        }
        return res;
    }//done

    public String getSpiritualMarriageName(int year) {
        String res = "";
        switch (year) {
            case 0:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5];
                break;
            case 1:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 2:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 3:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6];
                break;
            case 4:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 5:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 6:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7];
                break;
            case 7:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 8:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 9:
                res = C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 10:
                res = C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 11:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[10];
                break;
        }
        return res;
    }//done

    public String getPatriarchalMarriageName(int year) {
        String res = "";
        switch (year) {
            case 0:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[8];
                break;
            case 1:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 2:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 3:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 4:
                res = C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 5:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 6:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 7:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
            case 8:
                res = C.YEAR_NAMES[0] + ", " + C.YEAR_NAMES[4] + ", " + C.YEAR_NAMES[8];
                break;
            case 9:
                res = C.YEAR_NAMES[1] + ", " + C.YEAR_NAMES[5] + ", " + C.YEAR_NAMES[9];
                break;
            case 10:
                res = C.YEAR_NAMES[2] + ", " + C.YEAR_NAMES[6] + ", " + C.YEAR_NAMES[10];
                break;
            case 11:
                res = C.YEAR_NAMES[3] + ", " + C.YEAR_NAMES[7] + ", " + C.YEAR_NAMES[11];
                break;
        }
        return res;
    }//done

    public String getMeansCommunicateName(int year) {
        String res = "";
        if (year == 1 || year == 4 || year == 7 || year == 10) res = C.MEANS_COMMUNICATE_NAMES[0];
        else if (year == 0 || year == 3 || year == 6 || year == 9)
            res = C.MEANS_COMMUNICATE_NAMES[1];
        else if (year == 2 || year == 5 || year == 8 || year == 11)
            res = C.MEANS_COMMUNICATE_NAMES[2];
        return res;
    }

    public String getPsychologyName(int year) {
        String res = "";
        if (year == 0 || year == 1 || year == 2) res = C.PSYCHOLOGY_NAMES[0];
        else if (year == 3 || year == 4 || year == 5) res = C.PSYCHOLOGY_NAMES[1];
        else if (year == 6 || year == 7 || year == 8) res = C.PSYCHOLOGY_NAMES[2];
        else if (year == 9 || year == 10 || year == 11) res = C.PSYCHOLOGY_NAMES[3];
        return res;
    }

    public String getElementName(int day, int month) {
        String elementName = "";
        switch (month) {
            case 1:
                if (day >= 22) elementName = C.ELEMENT_NAMES[3];
                else elementName = C.ELEMENT_NAMES[1];
                break;
            case 2:
                if (day >= 21) elementName = C.ELEMENT_NAMES[0];
                else elementName = C.ELEMENT_NAMES[3];
                break;
            case 3:
                if (day >= 23) elementName = C.ELEMENT_NAMES[2];
                else elementName = C.ELEMENT_NAMES[0];
                break;
            case 4:
                if (day >= 22) elementName = C.ELEMENT_NAMES[1];
                else elementName = C.ELEMENT_NAMES[2];
                break;
            case 5:
                if (day >= 23) elementName = C.ELEMENT_NAMES[3];
                else elementName = C.ELEMENT_NAMES[1];
                break;
            case 6:
                if (day >= 22) elementName = C.ELEMENT_NAMES[0];
                else elementName = C.ELEMENT_NAMES[3];
                break;
            case 7:
                if (day >= 23) elementName = C.ELEMENT_NAMES[2];
                else elementName = C.ELEMENT_NAMES[0];
                break;
            case 8:
                if (day >= 22) elementName = C.ELEMENT_NAMES[1];
                else elementName = C.ELEMENT_NAMES[2];
                break;
            case 9:
                if (day >= 22) elementName = C.ELEMENT_NAMES[3];
                else elementName = C.ELEMENT_NAMES[1];
                break;
            case 10:
                if (day >= 22) elementName = C.ELEMENT_NAMES[0];
                else elementName = C.ELEMENT_NAMES[3];
                break;
            case 11:
                if (day >= 22) elementName = C.ELEMENT_NAMES[2];
                else elementName = C.ELEMENT_NAMES[0];
                break;
            case 12:
                if (day >= 22) elementName = C.ELEMENT_NAMES[1];
                else elementName = C.ELEMENT_NAMES[2];
                break;
            default:
                break;
        }
        return elementName;
    }

    public String getHostName(int year) {
        String res;
        res = C.YEAR_HOST_NAMES[year];
        return res;
    }//done

    public String getServantName(int year) {
        String res;
        res = C.YEAR_SERVANT_NAMES[year];
        return res;
    }//done

    public int getYearIdTable(int yearNow) {
        int res = yearNow % 12;
        switch (res) {
            case 0:
                res = 3;
                break;
            case 1:
                res = 0;
                break;
            case 2:
                res = 1;
                break;
            case 3:
                res = 2;
                break;
            case 4:
                res = 3;
                break;
            case 5:
                res = 0;
                break;
            case 6:
                res = 1;
                break;
            case 7:
                res = 2;
                break;
            case 8:
                res = 3;
                break;
            case 9:
                res = 0;
                break;
            case 10:
                res = 1;
                break;
            case 11:
                res = 2;
                break;
        }
        return res;
    }//done

    public int getTypeThinkingId(boolean man, int yearId) { // Возвращает id мышления
        int numberYear = 0;
        if (man) {
            if (yearId == 1 || yearId == 5 || yearId == 9) numberYear = 0;
            else if (yearId == 2 || yearId == 6 || yearId == 10) numberYear = 1;
            else if (yearId == 3 || yearId == 7 || yearId == 11) numberYear = 2;
            else if (yearId == 0 || yearId == 4 || yearId == 8) numberYear = 3;
        } else {
            if (yearId == 2 || yearId == 6 || yearId == 10) numberYear = 0;
            else if (yearId == 1 || yearId == 5 || yearId == 9) numberYear = 1;
            else if (yearId == 0 || yearId == 4 || yearId == 8) numberYear = 2;
            else if (yearId == 3 || yearId == 7 || yearId == 11) numberYear = 3;
        }
        return numberYear;
    }//done

    public String getYearPeriod(int yearIdTable, int typeThinking) { // Возвращает какой год: Преодоление...
        return YearPeriod[typeThinking][yearIdTable];
    }

    public String getTypeThinkingNames(boolean man, int year) { // Возвращает тип мышления
        String typeThinking = "";
        if (man) {
            if (year == 1 || year == 5 || year == 9) typeThinking = C.TYPE_THINKING_NAMES[0];
            else if (year == 2 || year == 6 || year == 10) typeThinking = C.TYPE_THINKING_NAMES[1];
            else if (year == 3 || year == 7 || year == 11) typeThinking = C.TYPE_THINKING_NAMES[2];
            else if (year == 0 || year == 4 || year == 8) typeThinking = C.TYPE_THINKING_NAMES[3];
        } else {
            if (year == 2 || year == 6 || year == 10) typeThinking = C.TYPE_THINKING_NAMES[0];
            else if (year == 1 || year == 5 || year == 9) typeThinking = C.TYPE_THINKING_NAMES[1];
            else if (year == 0 || year == 4 || year == 8) typeThinking = C.TYPE_THINKING_NAMES[2];
            else if (year == 3 || year == 7 || year == 11) typeThinking = C.TYPE_THINKING_NAMES[3];
        }
        return typeThinking;
    }//done

    public String getEnergyName(int year) { //вычисление темперамента(сангвиник, холерик...)
        String EnergyName = "";
        if (year == 3 || year == 5 || year == 10) EnergyName = C.ENERGY_STRUCTURE_NAMES[0];
        else if (year == 4 || year == 9 || year == 11) EnergyName = C.ENERGY_STRUCTURE_NAMES[1];
        else if (year == 1 || year == 6 || year == 8) EnergyName = C.ENERGY_STRUCTURE_NAMES[2];
        else if (year == 0 || year == 2 || year == 7) EnergyName = C.ENERGY_STRUCTURE_NAMES[3];
        return EnergyName;
    }//done



    ///
    public String getSymbolFate(int year) { //вычисление Знака судьбы
        String SymbolFate = "";
        if (year == 1 || year == 3 || year == 11) SymbolFate = C.SYMBOL_FATE_NAMES[0];
        else if (year == 2 || year == 4 || year == 6) SymbolFate = C.SYMBOL_FATE_NAMES[1];
        else if (year == 5 || year == 7 || year == 9) SymbolFate = C.SYMBOL_FATE_NAMES[2];
        else if (year == 0 || year == 8 || year == 10) SymbolFate = C.SYMBOL_FATE_NAMES[3];
        return SymbolFate;
    }//done

    public String getZodiakName(int day, int month) {
        String zodiakName = "";
        switch (month) {
            case 1:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[1];
                else zodiakName = C.ZODIAK_NAMES[0];
                break;
            case 2:
                if (day >= 21) zodiakName = C.ZODIAK_NAMES[2];
                else zodiakName = C.ZODIAK_NAMES[1];
                break;
            case 3:
                if (day >= 23) zodiakName = C.ZODIAK_NAMES[3];
                else zodiakName = C.ZODIAK_NAMES[2];
                break;
            case 4:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[4];
                else zodiakName = C.ZODIAK_NAMES[3];
                break;
            case 5:
                if (day >= 23) zodiakName = C.ZODIAK_NAMES[5];
                else zodiakName = C.ZODIAK_NAMES[4];
                break;
            case 6:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[6];
                else zodiakName = C.ZODIAK_NAMES[5];
                break;
            case 7:
                if (day >= 23) zodiakName = C.ZODIAK_NAMES[7];
                else zodiakName = C.ZODIAK_NAMES[6];
                break;
            case 8:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[8];
                else zodiakName = C.ZODIAK_NAMES[7];
                break;
            case 9:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[9];
                else zodiakName = C.ZODIAK_NAMES[8];
                break;
            case 10:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[10];
                else zodiakName = C.ZODIAK_NAMES[9];
                break;
            case 11:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[11];
                else zodiakName = C.ZODIAK_NAMES[10];
                break;
            case 12:
                if (day >= 22) zodiakName = C.ZODIAK_NAMES[0];
                else zodiakName = C.ZODIAK_NAMES[11];
                break;
            default:
                break;
        }
        return zodiakName;
    }//done

    public String getStructureType(int i, int j) {
        return StructureHor[i][j];
    }//done

    public String getStructureTypeAdmin(int i, int j) {
        return StructureHorADMIN[i][j];
    }//done
}
