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
        public int getDateId(int day,int month){
                int res = -1;
                switch (month) {
                        case 1:
                                if (day<=16)res = 0;
                                else if (day>=17&day<=27) res = 1;
                                else res = 2;
                                break;
                        case 2:
                                if (day<=15)res = 2;
                                else if (day>=16&day<=26) res = 3;
                                else res = 4;
                                break;
                        case 3:
                                if (day<=17)res = 4;
                                else if (day>=18&day<=28) res = 5;
                                else res = 6;
                                break;
                        case 4:
                                if (day<=16)res = 6;
                                else if (day>=17&day<=27) res = 7;
                                else res = 8;
                                break;
                        case 5:
                                if (day<=17)res = 8;
                                else if (day>=18&day<=28) res = 9;
                                else res = 10;
                                break;
                        case 6:
                                if (day<=16)res = 10;
                                else if (day>=17&day<=27) res = 11;
                                else res = 12;
                                break;
                        case 7:
                                if (day<=17)res = 12;
                                else if (day>=18&day<=28) res = 13;
                                else res = 14;
                                break;
                        case 8:
                                if (day<=16)res = 14;
                                else if (day>=17&day<=27) res = 15;
                                else res = 16;
                                break;
                        case 9:
                                if (day<=16)res = 16;
                                else if (day>=17&day<=27) res = 17;
                                else res = 18;
                                break;
                        case 10:
                                if (day<=16)res = 18;
                                else if (day>=17&day<=27) res = 19;
                                else res = 20;
                                break;
                        case 11:
                                if (day<=16)res = 20;
                                else if (day>=17&day<=27) res = 21;
                                else res = 22;
                                break;
                        case 12:
                                if (day<=16)res = 22;
                                else if (day>=17&day<=26) res = 23;
                                else res = 0;
                                break;
                        default:break;
                }
                return res;
        }
        public String getStructureType(int i,int j){
                return StructureHor[i][j];
        }
}
