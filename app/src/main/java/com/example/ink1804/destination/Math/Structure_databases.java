package com.example.ink1804.destination.Math;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class Structure_databases {
        Constants C = new Constants();
public String[][] StructureHor = {
        {C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR},
        {C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT},
        {C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT},
        {C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN},
        {C.KING,C.KING+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING},
        {C.VECTOR,C.VECTOR+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR},
        {C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT},
        {C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.ARISTOCRAT},
        {C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR},
        {C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.LEADER},
        {C.VECTOR,C.VECTOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KING,C.KING,C.KING+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER,C.LEADER,C.LEADER+"+"+C.VECTOR},
        {C.LEADER,C.LEADER+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.VECTOR,C.VECTOR,C.VECTOR+"+"+C.KING,C.KING,C.KING+"+"+C.CLOWN,C.CLOWN,C.CLOWN+"+"+C.KNIGHT,C.KNIGHT,C.KNIGHT+"+"+C.ARISTOCRAT,C.ARISTOCRAT,C.ARISTOCRAT+"+"+C.PROFESSOR,C.PROFESSOR,C.PROFESSOR+"+"+C.LEADER},
        };
}