package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.curses.Necronomicurse;
import com.megacrit.cardcrawl.cards.red.Bash;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.QuestionCard;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.cards.OneTwoPunchCard;
import dannyandjannymod.cards.StrongerBonesCard;

import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class MilkmanRelic extends BaseRelic {
    public static final String NAME = "MilkmanRelic";
    public static final String ID = makeID(NAME);

    public MilkmanRelic() {
        super(ID, NAME, RelicTier.SPECIAL, LandingSound.FLAT);
    }

    @Override
    public void onEquip() {
        CardCrawlGame.sound.play("NECRONOMICON");
        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(new StrongerBonesCard(), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(new OneTwoPunchCard(), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
        RemoveBash();
        AbstractDungeon.player.loseRelic("Burning Blood");
        //AbstractDungeon.player.getRelic("BreakfastRelic").obtain();
        new BreakfastRelic().instantObtain();
        new QuestionCard().instantObtain();
        AbstractDungeon.player.decreaseMaxHealth(10);
    }

    void RemoveBash() {
        AbstractCard cardToRemove = null;
        Iterator var2 = AbstractDungeon.player.masterDeck.group.iterator();

        while(var2.hasNext()) {
            AbstractCard c = (AbstractCard)var2.next();
            if (c instanceof Bash) {
                cardToRemove = c;
                break;
            }
        }

        if (cardToRemove != null) {
            AbstractDungeon.player.masterDeck.group.remove(cardToRemove);
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}