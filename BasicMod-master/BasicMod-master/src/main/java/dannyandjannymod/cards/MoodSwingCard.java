package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.optionCards.BecomeAlmighty;
import com.megacrit.cardcrawl.cards.optionCards.FameAndFortune;
import com.megacrit.cardcrawl.cards.optionCards.LiveForever;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.MoodSwingAction;
import dannyandjannymod.RankedgameAction;
import dannyandjannymod.stances.DepressedStance;
import dannyandjannymod.stances.TiltedStance;
import dannyandjannymod.util.CardInfo;

import java.util.ArrayList;
import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class MoodSwingCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MoodSwingCard",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 3;
    private static final int DAMAGE = 5;

    public MoodSwingCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));

        ArrayList<AbstractCard> stanceChoices = new ArrayList();
        stanceChoices.add(new BecomeTiltedCard());
        stanceChoices.add(new BecomeDepressedCard());
        if (this.upgraded) {
            Iterator var4 = stanceChoices.iterator();

            while(var4.hasNext()) {
                AbstractCard c = (AbstractCard)var4.next();
                c.upgrade();
            }
        }

        this.addToBot(new ChooseOneAction(stanceChoices));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MoodSwingCard();
    }
}