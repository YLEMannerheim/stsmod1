package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.sun.org.apache.xpath.internal.operations.Bool;
import dannyandjannymod.powers.CalciumPower;

import static dannyandjannymod.BasicMod.makeID;

public class CheeseWheelRelic extends BaseRelic {
    public static final String NAME = "CheeseWheelRelic";
    private static final int DRAW_AMOUNT = 1;
    public static final String ID = makeID(NAME);
    public Boolean triggeredThisTurn = false;

    public CheeseWheelRelic() {
        super(ID, NAME, RelicTier.COMMON, LandingSound.SOLID);
    }

    public int getDrawAmount() {
        return DRAW_AMOUNT;
    }

    @Override
    public void atTurnStart() {
        //setCounter(0);
        this.beginLongPulse();
        triggeredThisTurn = false;
    }

    @Override
    public void onVictory() {
        this.stopPulse();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DRAW_AMOUNT + DESCRIPTIONS[1];
    }
}