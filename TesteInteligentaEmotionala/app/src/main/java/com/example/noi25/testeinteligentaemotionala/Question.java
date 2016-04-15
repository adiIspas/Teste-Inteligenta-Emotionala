package com.example.noi25.testeinteligentaemotionala;

public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String ANSWER1;
    private String ANSWER2;

    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        ANSWER1 = "";
        ANSWER2 = "";
    }
    public Question(String question, String optA, String optB, String answer1, String answer2) {
        QUESTION = question;
        OPTA = optA;
        OPTB = optB;
        ANSWER1 = answer1;
        ANSWER2 = answer2;
    }

    public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getANSWER1() {
        return ANSWER1;
    }
    public String getANSWER2() {
        return ANSWER2;
    }

    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setANSWER1(String aNSWER) {
        ANSWER1 = aNSWER;
    }
    public void setANSWER2(String oPTC) {
        ANSWER2 = oPTC;
    }
}
