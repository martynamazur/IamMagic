package com.example.immagic.homepage.Play

import com.example.immagic.nawigation.categories.shop.boosts.BoostersItemModel

class RewardSystemManager(
    private val settingsModel: QuoteSettingsModel,
    private val quoteModel: List<QuoteModel>,
    private val activeBoostList: List<ActiveBoostModel>,
    private val quoteTimestamp: List<String>, //po kazdym odczytaniu zapisywana jest wartosc // koncowa to czas zakonczenia
    private val additionalyXPPoints: Int
)

{

    //Experience Point
    //Alchemy bottles
    //Time bonus
    //Boosts
    // n- ilosc kart
    // r - ilosc powtorzen setu
    // t - czas
    // bex - boost experience

    private fun countReward(): PlayRewardModel{

        if (activeBoostList.isEmpty()){
            return countBasic()
        }else{
            return countWithBoost()
        }


}
    private fun countBasic(): PlayRewardModel {
        val alchemyPointsBasic = quoteModel.size * settingsModel.repeatSetCounter
        val experiencePointsBasic = alchemyPointsBasic

        return PlayRewardModel(alchemyPointsBasic, experiencePointsBasic + additionalyXPPoints)
    }

    private fun countWithBoost(): PlayRewardModel {
        val playReward = countBasic()

        var withBoostXp = playReward.experiencePoints
        var withBoostBottles = playReward.alchemyBootlesNumber

        for (activeBoost in activeBoostList) {
            if (activeBoost.boostType == "XP") {
                withBoostXp *= activeBoost.boostMultiplier
            } else if (activeBoost.boostType == "Bootles") {
                withBoostBottles *= activeBoost.boostMultiplier
            }
        }

        return PlayRewardModel(withBoostBottles, withBoostXp )
    }

}