package com.giorgi.testirebaapp;

public class Question {
    private int mQuestionID;
    private boolean mAnswer;
    private int answerFirst;
    private int answerSecond;
    private int rightAnswer;

    public Question(int questionResourceID, int answer1, int answer2, int Which) {
        mQuestionID = questionResourceID;
        answerFirst = answer1;
        answerSecond = answer2;
        rightAnswer = Which;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public int getAnswerFirst() {
        return answerFirst;
    }

    public int getAnswerSecond() {
        return answerSecond;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public boolean isAnswer(int ans) {
        if (ans == rightAnswer)
            return true;
        else
            return false;
    }

}
