import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tutorcoffee.ListResepActivity
import com.example.tutorcoffee.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        // Set listener untuk CardView
        binding.cardAeropress.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            startActivity(intent)
        }

        binding.cardFrenchPress.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            startActivity(intent)
        }

        binding.cardChemex.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
