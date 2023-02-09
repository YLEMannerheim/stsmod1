package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.BigBreakfastAction;
import dannyandjannymod.MilkmanClassEnum;
import dannyandjannymod.powers.CalciumPower;

import static dannyandjannymod.BasicMod.makeID;

public class BigBreakfastRelic extends BaseRelic {
    public static final String NAME = "BigBreakfastRelic";
    public static final String ID = makeID(NAME);
    public static final int MAGIC = 3;
    public static final String RELIC_TO_REPLACE = "dannyandjanny:BreakfastRelic";


    public BigBreakfastRelic() {
        super(ID, NAME, RelicTier.BOSS, LandingSound.FLAT);
        pool = AbstractCardEnum.MILKMAN_WHITE;
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
        //if (AbstractDungeon.player.getRelicNames().get(0) != "BigBreakfastRelic")
        //    this.instantObtain(AbstractDungeon.player, 0, true);

        //this.addToBot(new BigBreakfastAction());
    }

    @Override
    public void obtain() {
        // Replace the starter relic, or just give the relic if starter isn't found
        if (AbstractDungeon.player.hasRelic(RELIC_TO_REPLACE)) {
            for (int i=0; i<AbstractDungeon.player.relics.size(); ++i) {
                if (AbstractDungeon.player.relics.get(i).relicId.equals(RELIC_TO_REPLACE)) {
                    instantObtain(AbstractDungeon.player, i, true);
                    break;
                }
            }
        } else {
            super.obtain();
        }
    }

    public boolean canSpawn() {
        return AbstractDungeon.player.hasRelic("dannyandjanny:BreakfastRelic");
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + MAGIC + DESCRIPTIONS[1];
    }
}