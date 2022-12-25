package dannyandjannymod.relics;

import basemod.abstracts.CustomRelic;
import basemod.helpers.RelicType;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import dannyandjannymod.cards.SpareBucketCard;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.TextureLoader;

import static dannyandjannymod.BasicMod.makeID;
import static dannyandjannymod.BasicMod.relicPath;

public class BreakfastRelic extends BaseRelic {
    public static final String NAME = "BreakfastRelic";
    public static final String ID = makeID(NAME);
    public static final int calciumAmount = 3;

    public BreakfastRelic() {
        super(ID, NAME, RelicTier.STARTER, LandingSound.FLAT);
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