import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.immagic.onboarding.OnboardingFragment1
import com.example.immagic.onboarding.OnboardingFragment2
import com.example.immagic.onboarding.OnboardingFragment3
import com.example.immagic.onboarding.OnboardingFragment4

class OnBoardingPagerAdapter(private val fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment1()
            1 -> OnboardingFragment2()
            2 -> OnboardingFragment3()
            3 -> OnboardingFragment4()
            else -> OnboardingFragment1() // Jeśli pozycja jest spoza zakresu, zwracamy domyślnie pierwszy fragment
        }
    }
}
