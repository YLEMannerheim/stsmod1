package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.DrinkingProblemAction;
import dannyandjannymod.KeyboardSmashAction;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class DrinkingProblemCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DrinkingProblemCard",
            -1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public DrinkingProblemCard() {
        super(cardInfo);
        setExhaust(true);
        cardsToPreview = new ChugCard();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DrinkingProblemAction(p, this.upgraded, this.freeToPlayOnce, this.energyOnUse));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DrinkingProblemCard();
    }
}