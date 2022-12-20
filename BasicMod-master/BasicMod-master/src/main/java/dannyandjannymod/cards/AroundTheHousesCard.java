package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.powers.FrailPower;
import dannyandjannymod.util.CardInfo;

import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class AroundTheHousesCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AroundTheHousesCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;

    public AroundTheHousesCard() {
        super(cardInfo);

        setMagic(MAGIC);

        setExhaust(true);
        setInnate(false, true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int count = 0;
        Iterator var4 = AbstractDungeon.getMonsters().monsters.iterator();

        while(var4.hasNext()) {
            AbstractMonster mon = (AbstractMonster)var4.next();
            if (!mon.isDeadOrEscaped()) {
                ++count;
            }
        }

        for(int i = 0; i < count; ++i) {
            this.addToBot(new DrawCardAction(p, magicNumber));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new AroundTheHousesCard();
    }
}