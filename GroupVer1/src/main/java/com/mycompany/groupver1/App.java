package com.mycompany.groupver1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;



/**
 * JavaFX App
 */
public class App extends Application {
    
    // this will keep track of the question num, the score and also the answer selected
    private int questionNumber =  1;
    private int score = 0;
    private String selectedAnswer = "";
    

    @Override
    public void start(Stage primaryStage) {
        
        
        // these are the main menu buttons
        Button math = new Button("Take Math Quiz");
        Button science= new Button("Take Science Quiz");
        Button history= new Button ("Take History Quiz");
        
        
        // this is the layout of the main menu
        VBox mainLayout = new VBox(15, math, science, history);
        mainLayout.setAlignment(Pos.CENTER);
        
        
        Scene mainScene = new Scene(mainLayout, 800, 500);
        
        
        // this is the start of the math quiz code
        
        
        // buttons to start the math quiz or go back to the main menu
        Button startMathQuiz = new Button("Press to start math quiz!");
        Button back1 = new Button("Back to Main Menu");
        
        
        // the layout of the math quiz
        VBox mathLayout = new VBox(15, startMathQuiz);
        mathLayout.setAlignment(Pos.CENTER);
        
        BorderPane mathPane = new BorderPane();
        mathPane.setTop(back1);
        mathPane.setCenter(mathLayout);
        
        Scene mathScene = new Scene(mathPane, 800, 500);
        
        
        
        math.setOnAction(e -> primaryStage.setScene(mathScene));
        back1.setOnAction(e -> primaryStage.setScene(mainScene));
        
        
        // math quiz questions
        
        
        // question numbers 1 - 3
        Base mathQuestion1 = new Base("What is 5 + 3?", "C");
        Base mathQuestion2 = new Base("What is 10 - 4?", "B");
        Base mathQuestion3 = new Base("What is 3 * 3?", "C");
        
        // display question number 1
        Label question1 = new Label(mathQuestion1.getQuestion());
        question1.setStyle("-fx-font-size: 30px;");
        Label questionCounter = new Label("1/3");
        questionCounter.setStyle("-fx-font-size: 20px;");
        
        
        //  creating four multiple choice options
        Button answerA = new Button("A. 6");
        Button answerB = new Button("B. 7");
        Button answerC = new Button("C. 8");
        Button answerD = new Button("D. 9");
        
        // this is what saves the answer when the user presses one
        answerA.setOnAction(e -> selectedAnswer = "A");
        answerB.setOnAction(e -> selectedAnswer = "B");    
        answerC.setOnAction(e -> selectedAnswer = "C");
        answerD.setOnAction(e -> selectedAnswer = "D");
        
        // adding a next question button
        Button nextQuestion = new Button("Next Question");
        
        // the layout of the questions
        VBox questionLayout = new VBox(15, question1, answerA, answerB, answerC, answerD);
        questionLayout.setAlignment(Pos.CENTER);
        
        
        //putting a question counter in the top right + next button in bottom right
        BorderPane questionPane = new BorderPane();
        
        questionPane.setTop(questionCounter);
        BorderPane.setAlignment(questionCounter, Pos.TOP_RIGHT);
        
        questionPane.setCenter(questionLayout);
        questionPane.setBottom(nextQuestion);
        BorderPane.setAlignment(nextQuestion, Pos.BOTTOM_RIGHT);
        
        Scene questionScene = new Scene(questionPane, 800,500);
        
        
        
        // displays the results of a quiz
        
        Label finalScore = new Label("");
        finalScore.setStyle("-fx-font-size: 30px");
        
        Button back4 = new Button("Back to Main Menu");
        
        VBox resultsLayout = new VBox(15, finalScore);
        resultsLayout.setAlignment(Pos.CENTER);
        
        BorderPane resultsPane = new BorderPane();
        resultsPane.setTop(back4);
        resultsPane.setCenter(resultsLayout);
        
        Scene resultsScene = new Scene(resultsPane, 800, 500);
        
        // brings you back to the main menu from results
        back4.setOnAction(e -> primaryStage.setScene(mainScene));
        
        
        
        startMathQuiz.setOnAction(e -> primaryStage.setScene(questionScene));
        
        
        
        // scoring and also the next question buttons for math quiz
        
        nextQuestion.setOnAction(e -> {
            if (selectedAnswer.equals("")){
                return;
            }
            
            // checks question number 1
            
            if (questionNumber == 1){
                if (mathQuestion1.checkAnswer(selectedAnswer)){
                    score ++;
                }
                question1.setText(mathQuestion2.getQuestion());
                
                answerA.setText("A. 4");
                answerB.setText("B. 6");
                answerC.setText("C. 8");
                answerD.setText("D. 10");
                
                questionCounter.setText("2/3");
                questionNumber = 2;
                
            // checks question number 2
            } else if (questionNumber == 2){
                if (mathQuestion2.checkAnswer(selectedAnswer)){
                    score++;
                }
                question1.setText(mathQuestion3.getQuestion());
                
                answerA.setText("A. 6");
                answerB.setText("B. 7");
                answerC.setText("C. 9");
                answerD.setText("D. 12");
                
                questionCounter.setText("3/3");
                questionNumber = 3;
                
            // checks question number 3           
            } else if (questionNumber == 3){
                if (mathQuestion3.checkAnswer(selectedAnswer)){
                    score++;
                }
                
                finalScore.setText("Your Score is: " + score + "/3");
                primaryStage.setScene(resultsScene);
            }
            

            
        selectedAnswer = "";
        });
 
        
        
        // SCIENCE QUIZ LAYOUT SCREEN
        Button startScienceQuiz = new Button("Press to start science quiz!");
        Button back2 = new Button("Back to Main Menu");
        
        VBox scienceLayout = new VBox(15, startScienceQuiz, back2);
        scienceLayout.setAlignment(Pos.CENTER);
        
        // MOVES BACK BUTTON TO TOP LEFT OF SCREEN - SCIENCE
        BorderPane sciencePane = new BorderPane();
        sciencePane.setTop(back2);
        sciencePane.setCenter(scienceLayout);
        
        Scene scienceScene = new Scene(sciencePane, 800, 500);
        
        science.setOnAction(e -> primaryStage.setScene(scienceScene));
        back2.setOnAction(e -> primaryStage.setScene(mainScene));
        
        
        // HISTORY QUIZ LAYOUT SCREEN

        Button startHistoryQuiz = new Button("Press to start history Quiz");
        Button back3 = new Button("Back to Main Menu");
        
        VBox historyLayout = new VBox(15, startHistoryQuiz, back3);
        historyLayout.setAlignment(Pos.CENTER);
        
        // MOVES BACK BUTTON TO TOP LEFT OF SCREEN - SCIENCE
        BorderPane historyPane = new BorderPane();
        historyPane.setTop(back3);
        historyPane.setCenter(historyLayout);
        
        Scene historyScene=new Scene(historyPane, 800, 500);
        
        history.setOnAction(e -> primaryStage.setScene(historyScene));
        back3.setOnAction(e-> primaryStage.setScene(mainScene));
        
        // this is what displays eveything
        primaryStage.setTitle("Quiz Time!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}