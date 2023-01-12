package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class MilkmanDefendCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MilkmanDefendCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.BASIC,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_BLOCK = 3;
    private static final int BLOCK = 5;

    public MilkmanDefendCard() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        this.tags.add(CardTags.STARTER_DEFEND);

        //setBackgroundTexture("dannyandjannymod/character/char_button.png", "dannyandjannymod/character/char_button.png");
        //setOrbTexture("dannyandjannymod/character/char_button.png", "dannyandjannymod/character/char_button.png");
        //setBannerTexture("dannyandjannymod/character/char_button.png", "dannyandjannymod/character/char_button.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MilkmanDefendCard();
    }
}