package keen.eye.ink1804.destination.Math;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class Data_calculation {
        public static final String[][] StructureHorADMIN = {
                {Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN},//обезьяна
                {Constants.KING, Constants.KING+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING},//петух
                {Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.VECTOR},//собака
                {Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT},//кабан
                {Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.ARISTOCRAT},//крыса
                {Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR},//бык
                {Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.LEADER},//тигр
                {Constants.VECTOR, Constants.VECTOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.VECTOR},//кот
                {Constants.LEADER, Constants.LEADER+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER},//дракон
                {Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.PROFESSOR},//змея
                {Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT, Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT},//лошадь
                {Constants.KNIGHT, Constants.KNIGHT+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.LEADER, Constants.LEADER, Constants.LEADER+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.PROFESSOR, Constants.PROFESSOR, Constants.PROFESSOR+"+"+ Constants.ARISTOCRAT, Constants.ARISTOCRAT, Constants.ARISTOCRAT+"+"+ Constants.VECTOR, Constants.VECTOR, Constants.VECTOR+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KING, Constants.KING, Constants.KING+"+"+ Constants.CLOWN, Constants.CLOWN, Constants.CLOWN+"+"+ Constants.KNIGHT},//коза
        };
        public static final String[][] StructureHor = {
                {Constants.CLOWN, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.VECTOR, Constants.LEADER, Constants.ARISTOCRAT, Constants.LEADER, Constants.PROFESSOR, Constants.VECTOR, Constants.KNIGHT, Constants.CLOWN, Constants.KING},//обезьяна
                {Constants.KING, Constants.VECTOR, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.LEADER, Constants.VECTOR, Constants.LEADER, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT, Constants.CLOWN},//петух
                {Constants.VECTOR, Constants.KING, Constants.CLOWN, Constants.KNIGHT, Constants.VECTOR, Constants.PROFESSOR, Constants.LEADER, Constants.ARISTOCRAT, Constants.LEADER, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT},//собака
                {Constants.KNIGHT, Constants.CLOWN, Constants.KING, Constants.CLOWN, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.VECTOR, Constants.ARISTOCRAT, Constants.VECTOR, Constants.PROFESSOR, Constants.ARISTOCRAT},//кабан
                {Constants.ARISTOCRAT, Constants.KNIGHT, Constants.CLOWN, Constants.KING, Constants.CLOWN, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.LEADER, Constants.VECTOR, Constants.LEADER, Constants.VECTOR},//крыса
                {Constants.PROFESSOR, Constants.VECTOR, Constants.KNIGHT, Constants.CLOWN, Constants.KING, Constants.VECTOR, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.LEADER, Constants.ARISTOCRAT, Constants.LEADER},//бык
                {Constants.LEADER, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT, Constants.VECTOR, Constants.KING, Constants.CLOWN, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.VECTOR, Constants.ARISTOCRAT},//тигр
                {Constants.VECTOR, Constants.LEADER, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT, Constants.CLOWN, Constants.KING, Constants.VECTOR, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.LEADER},//кот
                {Constants.LEADER, Constants.ARISTOCRAT, Constants.VECTOR, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT, Constants.VECTOR, Constants.KING, Constants.CLOWN, Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR},//дракон
                {Constants.PROFESSOR, Constants.LEADER, Constants.ARISTOCRAT, Constants.LEADER, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT, Constants.CLOWN, Constants.KING, Constants.CLOWN, Constants.VECTOR, Constants.VECTOR, Constants.VECTOR,},//змея
                {Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.VECTOR, Constants.VECTOR, Constants.VECTOR, Constants.LEADER, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.KNIGHT, Constants.CLOWN, Constants.KING, Constants.CLOWN, Constants.KNIGHT,},//лошадь
                {Constants.KNIGHT, Constants.ARISTOCRAT, Constants.PROFESSOR, Constants.LEADER, Constants.ARISTOCRAT, Constants.VECTOR, Constants.PROFESSOR, Constants.ARISTOCRAT, Constants.VECTOR, Constants.CLOWN, Constants.KING, Constants.CLOWN},//коза
        };
        public static final String[][] YearPeriod = {
                {Constants.P_PRESENTATION, Constants.P_OVERCOMING,   Constants.P_DISCUISE,     Constants.P_EASE},//Логики
                {Constants.P_EASE,         Constants.P_PRESENTATION, Constants.P_OVERCOMING,   Constants.P_DISCUISE},//Волевики
                {Constants.P_DISCUISE,     Constants.P_EASE,         Constants.P_PRESENTATION, Constants.P_OVERCOMING},//Реалисты
                {Constants.P_OVERCOMING,   Constants.P_DISCUISE,     Constants.P_EASE,         Constants.P_PRESENTATION},//Мистики
        };

        public int getDateIdAdmin(int day,int month){
                int res = -1;
                switch (month) {
                        case 1:
                                if (day<=16)res = 0;
                                else if (day>=17&&day<=27) res = 1;
                                else if (day>=28&&day<=31) res = 2;
                                break;
                        case 2:
                                if (day<=15)res = 2;
                                else if (day>=16&&day<=26) res = 3;
                                else if (day>=27&&day<=29) res = 4;
                                break;
                        case 3:
                                if (day<=17)res = 4;
                                else if (day>=18&&day<=28) res = 5;
                                else if (day>=29&&day<=31) res = 6;
                                break;
                        case 4:
                                if (day<=16)res = 6;
                                else if (day>=17&&day<=27) res = 7;
                                else if (day>=28&&day<=30) res = 8;
                                break;
                        case 5:
                                if (day<=17)res = 8;
                                else if (day>=18&&day<=28) res = 9;
                                else if (day>=29&&day<=31) res = 10;
                                break;
                        case 6:
                                if (day<=16)res = 10;
                                else if (day>=17&&day<=27) res = 11;
                                else if (day>=28&&day<=30) res = 12;
                                break;
                        case 7:
                                if (day<=17)res = 12;
                                else if (day>=18&&day<=28) res = 13;
                                else if (day>=29&&day<=31) res = 14;
                                break;
                        case 8:
                                if (day<=16)res = 14;
                                else if (day>=17&&day<=27) res = 15;
                                else if (day>=28&&day<=31) res = 16;
                                break;
                        case 9:
                                if (day<=16)res = 16;
                                else if (day>=17&&day<=27) res = 17;
                                else if (day>=28&&day<=30) res = 18;
                                break;
                        case 10:
                                if (day<=16)res = 18;
                                else if (day>=17&&day<=27) res = 19;
                                else if (day>=28&&day<=31) res = 20;
                                break;
                        case 11:
                                if (day<=16)res = 20;
                                else if (day>=17&&day<=27) res = 21;
                                else if (day>=28&&day<=30)res = 22;
                                break;
                        case 12:
                                if (day<=16)res = 22;
                                else if (day>=17&&day<=26) res = 23;
                                else if (day>=27&&day<=31) res = 0;
                                break;
                        default:break;
                }
                return res;
        }//done
        public int getDateId(int day,int month){
                int res = -1;
                switch (month) {
                        case 1:
                                if (day<=21)res = 0;
                                else res = 1;
                                break;
                        case 2:
                                if (day<=20)res = 1;
                                else res = 2;
                                break;
                        case 3:
                                if (day<=22)res = 2;
                                else res = 3;
                                break;
                        case 4:
                                if (day<=21)res = 3;
                                else res = 4;
                                break;
                        case 5:
                                if (day<=22)res = 4;
                                else res = 5;
                                break;
                        case 6:
                                if (day<=21)res = 5;
                                else res = 6;
                                break;
                        case 7:
                                if (day<=22)res = 6;
                                else res = 7;
                                break;
                        case 8:
                                if (day<=21)res = 7;
                                else res = 8;
                                break;
                        case 9:
                                if (day<=21)res = 8;
                                else res = 9;
                                break;
                        case 10:
                                if (day<=21)res = 9;
                                else res = 10;
                                break;
                        case 11:
                                if (day<=21)res = 10;
                                else res = 11;
                                break;
                        case 12:
                                if (day<=21)res = 11;
                                else res = 0;
                                break;
                        default:break;
                }
                return res;
        }//done
        public int getYearId(int year){
                return year%12;
        }//done
        public String getYearName(int year){
                String yearName="";
                yearName = Constants.YEAR_NAMES[year%12];
                return yearName;
        }//done
        public String getNumberYear(int yearNow, int month, int day){ // Возвращает число года
                int numberYear = 0;
                numberYear = yearNow+month+day;
                numberYear = SummChislo(numberYear);
                return String.valueOf(numberYear);
        }//done
        private int SummChislo(int Chislo) { // Суммирует каждую цифру числа
                int res = 0;
                        for (int i = 0; i < 4; i++) {
                                res += Chislo % 10;
                                Chislo = Chislo / 10;
                        }
                if(res>9) res = SummChislo(res);
                return res;
        }//done
        public String getMeansCommunicateName(int year) {
                String res = "";
                if(year==1||year==4||year==7||year==10) res = Constants.MEANS_COMMUNICATE_NAMES[0];
                else if(year==0||year==3||year==6||year==9) res = Constants.MEANS_COMMUNICATE_NAMES[1];
                else if(year==2||year==5||year==8||year==11) res = Constants.MEANS_COMMUNICATE_NAMES[2];
                return res;
        }
        public String getPsychologyName(int year) {
                String res = "";
                if(year==0||year==1||year==2) res = Constants.PSYCHOLOGY_NAMES[0];
                else if(year==3||year==4||year==5) res = Constants.PSYCHOLOGY_NAMES[1];
                else if(year==6||year==7||year==8) res = Constants.PSYCHOLOGY_NAMES[2];
                else if(year==9||year==10||year==11) res = Constants.PSYCHOLOGY_NAMES[3];
                return res;
        }
        public String getElementName(int day, int month) {
                String elementName = "";
                switch (month){
                        case 1:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[3]; else elementName = Constants.ELEMENT_NAMES[1]; break;
                        case 2:
                                if(day>=21) elementName = Constants.ELEMENT_NAMES[0]; else elementName = Constants.ELEMENT_NAMES[3]; break;
                        case 3:
                                if(day>=23) elementName = Constants.ELEMENT_NAMES[2]; else elementName = Constants.ELEMENT_NAMES[0]; break;
                        case 4:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[1]; else elementName = Constants.ELEMENT_NAMES[2]; break;
                        case 5:
                                if(day>=23) elementName = Constants.ELEMENT_NAMES[3]; else elementName = Constants.ELEMENT_NAMES[1]; break;
                        case 6:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[0]; else elementName = Constants.ELEMENT_NAMES[3]; break;
                        case 7:
                                if(day>=23) elementName = Constants.ELEMENT_NAMES[2]; else elementName = Constants.ELEMENT_NAMES[0]; break;
                        case 8:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[1]; else elementName = Constants.ELEMENT_NAMES[2]; break;
                        case 9:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[3]; else elementName = Constants.ELEMENT_NAMES[1]; break;
                        case 10:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[0]; else elementName = Constants.ELEMENT_NAMES[3]; break;
                        case 11:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[2]; else elementName = Constants.ELEMENT_NAMES[0]; break;
                        case 12:
                                if(day>=22) elementName = Constants.ELEMENT_NAMES[1]; else elementName = Constants.ELEMENT_NAMES[2]; break;
                        default: break;
                }
                return elementName;
        }
        public String getHostName(int year) {
                String res;
                res = Constants.YEAR_HOST_NAMES[year];
                return res;
        }//done
        public String getServantName(int year) {
                String res;
                res = Constants.YEAR_SERVANT_NAMES[year];
                return res;
        }//done
        public int getYearIdTable(int yearNow) {
                int res = yearNow%12;
                switch (res) {
                        case 0:res = 3; break;
                        case 1:res = 0; break;
                        case 2:res = 1; break;
                        case 3:res = 2; break;
                        case 4:res = 3; break;
                        case 5:res = 0; break;
                        case 6:res = 1; break;
                        case 7:res = 2; break;
                        case 8:res = 3; break;
                        case 9:res = 0; break;
                        case 10:res = 1; break;
                        case 11:res = 2; break;
                }
                return res;
        }//done
        public int getTypeThinkingId(boolean man, int yearId){ // Возвращает id мышления
                int numberYear = 0;
                if(man) {
                        if(yearId==1||yearId==5||yearId==9) numberYear = 0;
                        else if(yearId==2||yearId==6||yearId==10) numberYear = 1;
                        else if(yearId==3||yearId==7||yearId==11) numberYear = 2;
                        else if(yearId==0||yearId==4||yearId==8) numberYear = 3;
                } else {
                        if(yearId==2||yearId==6||yearId==10) numberYear = 0;
                        else if(yearId==1||yearId==5||yearId==9) numberYear = 1;
                        else if(yearId==0||yearId==4||yearId==8) numberYear = 2;
                        else if(yearId==3||yearId==7||yearId==11) numberYear = 3;
                }
                return numberYear;
        }//done
        public String getYearPeriod(int yearIdTable, int typeThinking){ // Возвращает какой год: Преодоление...
                return YearPeriod[typeThinking][yearIdTable];
        }
        public String getTypeThinkingNames(boolean man, int year){ // Возвращает тип мышления
                String typeThinking="";
                if(man) {
                        if(year==1||year==5||year==9) typeThinking = Constants.TYPE_THINKING_NAMES[0];
                        else if(year==2||year==6||year==10) typeThinking = Constants.TYPE_THINKING_NAMES[1];
                        else if(year==3||year==7||year==11) typeThinking = Constants.TYPE_THINKING_NAMES[2];
                        else if(year==0||year==4||year==8) typeThinking = Constants.TYPE_THINKING_NAMES[3];
                } else {
                        if(year==2||year==6||year==10) typeThinking = Constants.TYPE_THINKING_NAMES[0];
                        else if(year==1||year==5||year==9) typeThinking = Constants.TYPE_THINKING_NAMES[1];
                        else if(year==0||year==4||year==8) typeThinking = Constants.TYPE_THINKING_NAMES[2];
                        else if(year==3||year==7||year==11) typeThinking = Constants.TYPE_THINKING_NAMES[3];
                }
                return typeThinking;
        }//done
        public String getEnergyName(int year){ //вычисление темперамента(сангвиник, холерик...)
                String EnergyName="";
                if(year==3||year==5||year==10) EnergyName = Constants.ENERGY_STRUCTURE_NAMES[0];
                else if(year==4||year==9||year==11) EnergyName = Constants.ENERGY_STRUCTURE_NAMES[1];
                else if(year==1||year==6||year==8) EnergyName = Constants.ENERGY_STRUCTURE_NAMES[2];
                else if(year==0||year==2||year==7) EnergyName = Constants.ENERGY_STRUCTURE_NAMES[3];
                return EnergyName;
        }//done
        public String getSymbolFate(int year){ //вычисление Знака судьбы
                String SymbolFate="";
                if(year==1||year==3||year==11) SymbolFate = Constants.SYMBOL_FATE_NAMES[0];
                else if(year==2||year==4||year==6) SymbolFate = Constants.SYMBOL_FATE_NAMES[1];
                else if(year==5||year==7||year==9) SymbolFate = Constants.SYMBOL_FATE_NAMES[2];
                else if(year==0||year==8||year==10) SymbolFate = Constants.SYMBOL_FATE_NAMES[3];
                return SymbolFate;
        }//done
        public String getZodiakName(int day,int month){
                String zodiakName = "";
                switch (month){
                        case 1:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[1]; else zodiakName = Constants.ZODIAK_NAMES[0]; break;
                        case 2:
                                if(day>=21) zodiakName = Constants.ZODIAK_NAMES[2]; else zodiakName = Constants.ZODIAK_NAMES[1]; break;
                        case 3:
                                if(day>=23) zodiakName = Constants.ZODIAK_NAMES[3]; else zodiakName = Constants.ZODIAK_NAMES[2]; break;
                        case 4:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[4]; else zodiakName = Constants.ZODIAK_NAMES[3]; break;
                        case 5:
                                if(day>=23) zodiakName = Constants.ZODIAK_NAMES[5]; else zodiakName = Constants.ZODIAK_NAMES[4]; break;
                        case 6:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[6]; else zodiakName = Constants.ZODIAK_NAMES[5]; break;
                        case 7:
                                if(day>=23) zodiakName = Constants.ZODIAK_NAMES[7]; else zodiakName = Constants.ZODIAK_NAMES[6]; break;
                        case 8:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[8]; else zodiakName = Constants.ZODIAK_NAMES[7]; break;
                        case 9:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[9]; else zodiakName = Constants.ZODIAK_NAMES[8]; break;
                        case 10:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[10]; else zodiakName = Constants.ZODIAK_NAMES[9]; break;
                        case 11:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[11]; else zodiakName = Constants.ZODIAK_NAMES[10]; break;
                        case 12:
                                if(day>=22) zodiakName = Constants.ZODIAK_NAMES[0]; else zodiakName = Constants.ZODIAK_NAMES[11]; break;
                        default: break;
                }
                return zodiakName;
        }//done
        public String getStructureType(int i,int j){
                return StructureHor[i][j];
        }//done
        public String getStructureTypeAdmin(int i,int j){
                return StructureHorADMIN[i][j];
        }//done
        public String getEqualMarriage(int year) {
                String res = "";
                switch (year) {
                        case 0:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 1:res = Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 2:res = Constants.YEAR_NAMES[9]; break;
                        case 3:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]; break;
                        case 4:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 5:res = Constants.YEAR_NAMES[10]; break;
                        case 6:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 7:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]; break;
                        case 8:res = Constants.YEAR_NAMES[11]; break;
                        case 9:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 10:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 11:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                }
                return res;
        }//done
        public String getRomanticMarriage(int year) {
                String res = "";
                switch (year) {
                        case 0:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 1:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 2:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 3:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 4:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]; break;
                        case 5:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 6:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 7:res = Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 8:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 9:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]; break;
                        case 10:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 11:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]; break;
                }
                return res;
        }//done
        public String getSpiritualMarriage(int year) {
                String res = "";
                switch (year) {
                        case 0:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]; break;
                        case 1:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 2:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 3:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]; break;
                        case 4:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 5:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 6:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]; break;
                        case 7:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 8:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 9:res = Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 10:res = Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 11:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[10]; break;
                }
                return res;
        }//done
        public String getPatriarchalMarriage(int year) {
                String res = "";
                switch (year) {
                        case 0:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 1:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 2:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 3:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 4:res = Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 5:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 6:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 7:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                        case 8:res = Constants.YEAR_NAMES[0]+", "+ Constants.YEAR_NAMES[4]+", "+ Constants.YEAR_NAMES[8]; break;
                        case 9:res = Constants.YEAR_NAMES[1]+", "+ Constants.YEAR_NAMES[5]+", "+ Constants.YEAR_NAMES[9]; break;
                        case 10:res = Constants.YEAR_NAMES[2]+", "+ Constants.YEAR_NAMES[6]+", "+ Constants.YEAR_NAMES[10]; break;
                        case 11:res = Constants.YEAR_NAMES[3]+", "+ Constants.YEAR_NAMES[7]+", "+ Constants.YEAR_NAMES[11]; break;
                }
                return res;
        }//done
        public String getVectorMarriage(int year) {
                String res = "";

                switch (year) {
                        case 0:res = "Хозяин: "+ Constants.YEAR_NAMES[9]+", Слуга: "+ Constants.YEAR_NAMES[4]; break;
                        case 1:res = "Хозяин: "+ Constants.YEAR_NAMES[7]+", Слуга: "+ Constants.YEAR_NAMES[2]; break;
                        case 2:res = "Хозяин: "+ Constants.YEAR_NAMES[1]+", Слуга: "+ Constants.YEAR_NAMES[5]; break;
                        case 3:res = "Хозяин: "+ Constants.YEAR_NAMES[10]+", Слуга: "+ Constants.YEAR_NAMES[8]; break;
                        case 4:res = "Хозяин: "+ Constants.YEAR_NAMES[0]+", Слуга: "+ Constants.YEAR_NAMES[10]; break;
                        case 5:res = "Хозяин: "+ Constants.YEAR_NAMES[2]+", Слуга: "+ Constants.YEAR_NAMES[6]; break;
                        case 6:res = "Хозяин: "+ Constants.YEAR_NAMES[5]+", Слуга: "+ Constants.YEAR_NAMES[11]; break;
                        case 7:res = "Хозяин: "+ Constants.YEAR_NAMES[8]+", Слуга: "+ Constants.YEAR_NAMES[1]; break;
                        case 8:res = "Хозяин: "+ Constants.YEAR_NAMES[3]+", Слуга: "+ Constants.YEAR_NAMES[7]; break;
                        case 9:res = "Хозяин: "+ Constants.YEAR_NAMES[11]+", Слуга: "+ Constants.YEAR_NAMES[0]; break;
                        case 10:res = "Хозяин: "+ Constants.YEAR_NAMES[4]+", Слуга: "+ Constants.YEAR_NAMES[3]; break;
                        case 11:res = "Хозяин: "+ Constants.YEAR_NAMES[6]+", Слуга: "+ Constants.YEAR_NAMES[9]; break;
                }
                return res;
        }
        public String getVirtualPointsName(String vir1, String vir2) {
                String res = "";
                String five = "5 (Отлично)", four = "4 (Хорошо)", three = "3 (Нормально)";
                if(vir1.equals(Constants.KING)) {
                    if(vir2.equals(Constants.KING) || vir2.equals(Constants.CLOWN)) res = five;
                    else if(vir2.equals(Constants.LEADER) || vir2.equals(Constants.VECTOR)) res = three;
                        else res = four;
                }
                else if(vir1.equals(Constants.ARISTOCRAT)) {
                        if(vir2.equals(Constants.KNIGHT) || vir2.equals(Constants.CLOWN)) res = five;
                        else if(vir2.equals(Constants.PROFESSOR) || vir2.equals(Constants.VECTOR)) res = three;
                        else res = four;
                }
                else if(vir1.equals(Constants.KNIGHT)) {
                        if(vir2.equals(Constants.ARISTOCRAT) || vir2.equals(Constants.VECTOR)) res = five;
                        else if(vir2.equals(Constants.KNIGHT) || vir2.equals(Constants.PROFESSOR)) res = three;
                        else res = four;
                }
                else if(vir1.equals(Constants.PROFESSOR)) {
                        if(vir2.equals(Constants.PROFESSOR) || vir2.equals(Constants.LEADER)) res = five;
                        else if(vir2.equals(Constants.ARISTOCRAT) || vir2.equals(Constants.KNIGHT)) res = three;
                        else res = four;
                }
                else if(vir1.equals(Constants.CLOWN)) {
                        if(vir2.equals(Constants.KING) || vir2.equals(Constants.ARISTOCRAT)) res = five;
                        else if(vir2.equals(Constants.CLOWN) || vir2.equals(Constants.LEADER)) res = three;
                        else res = four;
                }
                else if(vir1.equals(Constants.LEADER)) {
                        if(vir2.equals(Constants.PROFESSOR) || vir2.equals(Constants.VECTOR)) res = five;
                        else if(vir2.equals(Constants.KING) || vir2.equals(Constants.CLOWN)) res = three;
                        else res = four;
                }
                else {
                        if(vir2.equals(Constants.KNIGHT) || vir2.equals(Constants.LEADER)) res = five;
                        else if(vir2.equals(Constants.KING) || vir2.equals(Constants.ARISTOCRAT)) res = three;
                        else res = four;
                }

                return res;
        }
        public int getZodiacId(String zodiac){
                for(int i=0;i<12;i++){
                        if(Constants.ZODIAK_NAMES_normal[i].equals(zodiac))
                                return i;
                }
                return -1;
        }
        public int dpToPx(int dp, Context context) {
                /**
                 * Converting dp to pixel
                 */
                Resources r = context.getApplicationContext().getResources();
                return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
        }
}
