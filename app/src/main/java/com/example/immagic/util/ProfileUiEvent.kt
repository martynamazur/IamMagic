package com.example.immagic.util
//Myprofile
/*
ViewModel do przekazywania zdarzeń
związanych z interfejsem użytkownika
(UI) z widoku do ViewModel. Na przykład,
jeśli użytkownik naciska przycisk na ekranie,
zdarzenie związane z tym przyciskiem może
być reprezentowane przez instancję UiEvent.
ViewModel może następnie reagować na to zdarzenie,
podejmować odpowiednie działania i zaktualizować dane w Modelu.
 */
sealed  class ProfileUiEvent {
    object WelcomeMessageEvennt: ProfileUiEvent()
    object LoadStatistic: ProfileUiEvent()
    //object MyAddedCards: UiEvent()
    //object MyRecordings: UiEvent()
    //object MyShop: UiEvent()


}
