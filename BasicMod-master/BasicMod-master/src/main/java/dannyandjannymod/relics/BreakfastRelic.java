package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.CalciumPower;

import static dannyandjannymod.BasicMod.makeID;

public class BreakfastRelic extends BaseRelic {
    public static final String NAME = "BreakfastRelic";
    public static final String ID = makeID(NAME);
    public static final int calciumAmount = 3;

    public BreakfastRelic() {
        super(ID, NAME, RelicTier.STARTER, LandingSound.FLAT);
        pool = AbstractCardEnum.MILKMAN_WHITE;
    }

    @Override
    public void atBattleStart() {
        this.flash();

        AbstractPlayer p = AbstractDungeon.player;
        this.addToTop(new ApplyPowerAction(p, p, new CalciumPower(p, calciumAmount), calciumAmount));

        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + calciumAmount + DESCRIPTIONS[1];
    }
}