/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.dto;

/**
 *
 * @author zdeněk
 */
public class SetDTO extends AbstractDTO {
    
    private int number;
    private int score;
    protected  NoteDTO note;

    public SetDTO(Long id, int number, int score, NoteDTO note) {
        super(id);
        this.number = number;
        this.score = score;
        this.note = note;
    }
    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public NoteDTO getNote() {
        return note;
    }

    public void setNote(NoteDTO note) {
        this.note = note;
    }
}
