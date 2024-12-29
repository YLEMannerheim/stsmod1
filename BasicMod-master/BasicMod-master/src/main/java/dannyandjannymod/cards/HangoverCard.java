package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.powers.DrainedPower;
import dannyandjannymod.powers.KorvalePower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class HangoverCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HangoverCard",
            1,
            CardType.STATUS,
            CardTarget.NONE,
            CardRarity.COMMON,
            CardColor.COLORLESS);

    public static final String ID = makeID(cardInfo.baseId);


    public HangoverCard() {
        super(cardInfo);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.dontTriggerOnUseCard) {
            this.addToBot(new ApplyPowerAction(p, p, new DrainedPower(p, 1), 1));
        }
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HangoverCard();
    }
}