package ua.lviv.footgo.entity;

import javax.persistence.*;

@Entity
public class GameStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private int strikes;

    @Column
    private int hitsTheTarget;

    @Column
    private int strikesPastTheGate;

    @Column
    private int freeKicks;

    @Column
    private int fouls;

    @Column
    private int cornerKicks;

    public Long getId() {
        return id;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getHitsTheTarget() {
        return hitsTheTarget;
    }

    public void setHitsTheTarget(int hitsTheTarget) {
        this.hitsTheTarget = hitsTheTarget;
    }

    public int getStrikesPastTheGate() {
        return strikesPastTheGate;
    }

    public void setStrikesPastTheGate(int strikesPastTheGate) {
        this.strikesPastTheGate = strikesPastTheGate;
    }

    public int getFreeKicks() {
        return freeKicks;
    }

    public void setFreeKicks(int freeKicks) {
        this.freeKicks = freeKicks;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getCornerKicks() {
        return cornerKicks;
    }

    public void setCornerKicks(int cornerKicks) {
        this.cornerKicks = cornerKicks;
    }

}
