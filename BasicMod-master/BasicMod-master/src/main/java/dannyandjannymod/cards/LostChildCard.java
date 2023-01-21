package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class LostChildCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LostChildCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.SPECIAL,
            CardColor.COLORLESS);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 10;
    public static final int UPG_MAGIC = 15;


    public LostChildCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        //this.cardsToPreview = new RelievedRelativeCard();
        setEthereal(true);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        /*
        for(int i = 0; i < this.magicNumber; i++) {
            AbstractCard c = new RelievedRelativeCard().makeCopy();
            this.addToBot(new MakeTempCardInDrawPileAction(c, 1, true, true));
        }
        */
        CardCrawlGame.sound.play("GOLD_GAIN", 0.1F);
        this.addToBot(new GainGoldAction(this.magicNumber));

        for(int i = 0; i < this.magicNumber; ++i) {
            AbstractDungeon.effectList.add(new GainPennyEffect(p, this.hb.cX, this.hb.cY, p.hb.cX, p.hb.cY, true));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LostChildCard();
    }
}