package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class JaniCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "JaniCard",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public JaniCard() {
        super(cardInfo);
        this.tags.add(CustomTags.CHARACTER);
        cardsToPreview = new SleepingMedsCard();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard card = new SleepingMedsCard();
        if (this.upgraded)
            card.upgrade();
        this.addToBot(new MakeTempCardInHandAction(card));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new JaniCard();
    }
}