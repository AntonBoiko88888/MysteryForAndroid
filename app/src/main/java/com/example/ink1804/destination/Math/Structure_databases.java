package com.example.ink1804.destination.Math;

import java.util.Date;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class Structure_databases {
        static Constants C = new Constants();
        public static final String[][] StructureHor = {
                {C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN},//обезьяна
                {C.KING,C.KING+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING},//петух
                {C.VECTOR,C.VECTOR+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR},//собака
                {C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT},//кабан
                {C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.ARISTOCRAT},//крыса
                {C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR},//бык
                {C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER},//тигр
                {C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR},//кот
                {C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER},//дракон
                {C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR},//змея
                {C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT},//лошадь
                {C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT},//коза
        };
        public int getYearId(String year){
                return Integer.parseInt(year)%12;
        }
        public String getYearName(String year){
                String yearName="";
                yearName = C.YEAR_NAMES[Integer.parseInt(year)%12];
                return yearName;
        }
        public String getZodiakName(int day,int month){
                String zodiakName = "";
                switch (month){
                        case 1:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[1]; else zodiakName = C.ZODIAK_NAMES[0]; break;
                        case 2:
                                if(day>=21) zodiakName = C.ZODIAK_NAMES[2]; else zodiakName = C.ZODIAK_NAMES[1]; break;
                        case 3:
                                if(day>=23) zodiakName = C.ZODIAK_NAMES[3]; else zodiakName = C.ZODIAK_NAMES[2]; break;
                        case 4:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[4]; else zodiakName = C.ZODIAK_NAMES[3]; break;
                        case 5:
                                if(day>=23) zodiakName = C.ZODIAK_NAMES[5]; else zodiakName = C.ZODIAK_NAMES[4]; break;
                        case 6:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[6]; else zodiakName = C.ZODIAK_NAMES[5]; break;
                        case 7:
                                if(day>=23) zodiakName = C.ZODIAK_NAMES[7]; else zodiakName = C.ZODIAK_NAMES[6]; break;
                        case 8:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[8]; else zodiakName = C.ZODIAK_NAMES[7]; break;
                        case 9:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[9]; else zodiakName = C.ZODIAK_NAMES[8]; break;
                        case 10:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[10]; else zodiakName = C.ZODIAK_NAMES[9]; break;
                        case 11:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[11]; else zodiakName = C.ZODIAK_NAMES[10]; break;
                        case 12:
                                if(day>=22) zodiakName = C.ZODIAK_NAMES[0]; else zodiakName = C.ZODIAK_NAMES[11]; break;
                        default: break;
                }
                return zodiakName;
        }
        public int getDateId(int day,int month){
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
        }
        public String getStructureType(int i,int j){
                return StructureHor[i][j];
        }
}
