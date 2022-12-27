package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.powers.CalciumPower;

import static dannyandjannymod.BasicMod.makeID;

public class BigBreakfastRelic extends BaseRelic {
    public static final String NAME = "BigBreakfastRelic";
    public static final String ID = makeID(NAME);
    public static final int MAGIC = 3;

    public BigBreakfastRelic() {
        super(ID, NAME, RelicTier.BOSS, LandingSound.FLAT);
    }

    @Override
    public void atBattleStart() {
        this.flash();

        AbstractPlayer p = AbstractDungeon.player;
        this.addToTop(new ApplyPowerAction(p, p, new StrengthPower(p, MAGIC), MAGIC));
        this.addToTop(new ApplyPowerAction(p, p, new DexterityPower(p, MAGIC), MAGIC));

        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }

    @Override
    public void onEquip() {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasRelic("BreakfastRelic")) {
            p.loseRelic("BreakfastRelic");
        }
        super.onEquip();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + MAGIC + DESCRIPTIONS[1];
    }
}