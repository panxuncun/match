package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/19
 * @Description:
 */
public class ContestCheckDto {
    private long contestId;

    //1->pass   0->forbidden
    private int status;

    //checker
    private long lastCheckId;

    //note
    private String LastCheckNote;

    public long getContestId() {
        return contestId;
    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getLastCheckId() {
        return lastCheckId;
    }

    public void setLastCheckId(long lastCheckId) {
        this.lastCheckId = lastCheckId;
    }

    public String getLastCheckNote() {
        return LastCheckNote;
    }

    public void setLastCheckNote(String lastCheckNote) {
        this.LastCheckNote = lastCheckNote;
    }
}
