package com.guet.match.dto;

/**
 * @Auther: sefer
 * @Date: 2020/3/19
 * @Description: 审核赛事所需的参数
 */
public class CheckContestParam {
    private long contestId;

    //审核结果 1->pass   0->forbidden
    private int status;

    //审核人
    private long lastCheckId;

    //审核备注
    private String LastCheckNote;

    @Override
    public String toString() {
        return "CheckContestParam{" +
                "contestId=" + contestId +
                ", status=" + status +
                ", lastCheckId=" + lastCheckId +
                ", LastCheckNote='" + LastCheckNote + '\'' +
                '}';
    }

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
