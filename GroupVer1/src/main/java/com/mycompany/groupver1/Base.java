/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupver1;


/**
 *
 * @author mlico
 */
public class Base {
    private String question;
    private String answer;
    private int score;
    
    
    public Base(String question, String answer){
        this.question=question; 
        this.answer = answer;
    }
    
    
    
    // this will return the quizzes question
    public String getQuestion(){
        return question;
    }
    
    // this will check if the users answere is correct
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer.equals (answer)) {
            return true;           
        } else {
            return false;
        }
    }
    
    
    // this makes the score increase when the user gets a correct answer
    public int scoreTracker(boolean isCorrect){
        if (isCorrect == true){
            score++;
        }
        return score;
    }

}