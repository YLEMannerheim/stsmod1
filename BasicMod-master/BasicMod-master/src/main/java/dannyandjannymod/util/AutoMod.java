package dannyandjannymod.util;

import basemod.abstracts.AbstractCardModifier;
import basemod.cardmods.EtherealMod;
import basemod.cardmods.ExhaustMod;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import dannyandjannymod.CustomTags;

import static dannyandjannymod.BasicMod.makeID;

public class AutoMod extends AbstractCardModifier {
    public static String ID = makeID("AutoMod");

    boolean naturallyUnplayable = false;

    public AutoMod() {
    }

    public String modifyDescription(String rawDescription, AbstractCard card) {
        return naturallyUnplayable ? "Auto. NL " + rawDescription : "Unplayable. NL Auto. NL " + rawDescription;
    }

    public boolean shouldApply(AbstractCard card) {
        return !card.hasTag(CustomTags.AUTO);
    }

    public void onInitialApplication(AbstractCard card) {
        card.tags.add(CustomTags.AUTO);
        if (card.cost == -2)
            naturallyUnplayable = true;
    }

    @Override
    public void atEndOfTurn(AbstractCard card, CardGroup group) {
        if (!AbstractDungeon.player.hand.contains(card))
            return;

        for (int i = 0; i < EnergyPanel.totalCount; i++) {
            AbstractMonster m = AbstractDungeon.getMonsters().getRandomMonster((AbstractMonster)null, true, AbstractDungeon.cardRandomRng);
            card.use(AbstractDungeon.player, m);
        }
    }

    @Override
    public boolean canPlayCard(AbstractCard card) {
        card.cantUseMessage = "I cannot play cards with #rAuto.";
        return false;
    }

    public void onRemove(AbstractCard card) {
        card.tags.remove(CustomTags.AUTO);
    }

    public AbstractCardModifier makeCopy() {
        return new AutoMod();
    }

    public String identifier(AbstractCard card) {
        return ID;
    }
}