package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.actions.watcher.NotStanceCheckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.vfx.combat.EmptyStanceEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.orbs.VoicesOrb;
import dannyandjannymod.stances.ChilledStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class KetamineCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "KetamineCard",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public KetamineCard() {
        super(cardInfo);
        setExhaust(true, false);
        setBlock(10, 3);
        setMagic(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new NotStanceCheckAction("Neutral", new VFXAction(new EmptyStanceEffect(p.hb.cX, p.hb.cY), 0.1F)));
        this.addToBot(new ChangeStanceAction(ChilledStance.STANCE_ID));
        for (int i = 0; i < magicNumber; i++) {
            this.addToBot(new ChannelAction(new VoicesOrb()));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new KetamineCard();
    }
}