package com.example.miniprojectbottomnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.miniprojectbottomnavigation.R

class SchoolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_school, container, false)

        // Inside your fragment code
        val parentLayout = view.findViewById<LinearLayout>(R.id.parentLayout)

        // Create a list of data to populate the layouts
        val data = listOf(
            InfoItem("EST Meknes en bref", "l’Ecole Supérieure de Technologie, EST Meknès, est une école dont la vocation est de former des techniciens supérieurs dans diverses disciplines.\n" +
                    "\n" +
                    "L’EST Meknes compte environs 1300 étudiants, la durée d’étude est étalée sur 2 années (4 semestres), dans lequel il y’a un complémentarité entre les études théoriques et les stages obligatoires effectués.\n" +
                    "\n" +
                    "L’accès à l’EST Meknes est ouvert (selon la filière désirée) aux bacheliers des branches suivantes :\n" +
                    "\n" +
                    "Sciences Expérimentales : Filière Physique Chimie, Sciences de la Vie et de la Terre, Sciences Agronomiques\n" +
                    "Sciences Maths  : Sciences Maths A, Sciences Maths B\n" +
                    "Techniques  : Electronique, Electrotechnique, Filière Sciences & Technologies Electrique, Filière Sciences & Technologies Mécanique, Art Appliqué\n" +
                    "Filières gestion  : Sciences Economiques, Filière Gestion Comptable, Tech. de Gestion Administrative, Tech. de Gestion Comptable\n" +
                    "Filières Lettres : Lettres Modernes, Sciences Humaines"),
            InfoItem("Filières", "Techniques de management\n" +
                    "1. Génie électrique\n" +
                    "2. Génie des procédés\n" +
                    "3. Techniques de commercialisation et de communication\n" +
                    "4. Génie urbain et environnement\n" +
                    "5. Techniques instrumentales\n" +
                    "6. Génie mécanique et productique\n" +
                    "7. Informatique\n" +
                    "8. Gestion logistique et transport\n" +
                    "9. Génie informatique\n" +
                    "10. Génie biotechnologique\n" +
                    "11. Organisation et gestion des entreprises\n" +
                    "12. Techniques comptables\n" +
                    "13. Maintenance industrielle\n" +
                    "14. Génie bio-industriel\n" +
                    "15. Statistique et informatique industrielle\n" +
                    "16. Maitrise de l’énergie et énergies renouvelables\n" +
                    "17. Gestion des ressources humaines\n" +
                    "18. Animation et gestion touristique\n" +
                    "19. Métiers du web\n" +
                    "20. Réseaux et télécoms\n" +
                    "21. Agroalimentaire et génie biologique"),
            InfoItem("Diplômes", "1. Diplôme Universitaire de Technologie (DUT)\n" +
                    "2. Licence professionnelle"),
            InfoItem("Durée d'études", "3 ans d’études."),
            InfoItem("Formations", "✔ DUT en Techniques Comptable - EST Meknès\n" +
                    "✔ DUT en Technique de management - EST Meknès\n" +
                    "✔ DUT en Génie Informatique - EST Meknès\n" +
                    "✔ DUT en Génie Electrique - EST Meknès\n" +
                    "✔ DUT en Techniques de Commercialisation et de Communication - EST Meknès\n" +
                    "✔ DUT en Administrateur de Bases de Données (ADB) - EST Meknès\n" +
                    "✔ DUT en Administrateur d\u0092Applications d\u0092Entreprises - EST Meknès\n" +
                    "✔ DUT en Techniques de Vente et Services Clientèles - EST Meknès\n" +
                    "✔ DUT en Informatique, Systèmes et Réseaux - EST Meknès\n" +
                    "✔ DUT en Génie Logiciel - EST Meknès"),
            // Add more items as needed
        )

        // Loop through the data and inflate the layout for each item
        for (item in data) {
            val infoLayout =
                inflater.inflate(R.layout.item_info_layout, parentLayout, false)

            // Find views within the inflated layout
            val titleInfo = infoLayout.findViewById<TextView>(R.id.titleInfo)
            val textInfo = infoLayout.findViewById<TextView>(R.id.textInfo)
//            val imageInfo = infoLayout.findViewById<ImageView>(R.id.imageInfo)

            // Update views with item-specific data
            titleInfo.text = item.title
            textInfo.text = item.text
//            imageInfo.setImageResource(item.imageResource)

            // Add the inflated layout to the parent view
            parentLayout.addView(infoLayout)
        }

        return view
    }

    data class InfoItem(val title: String, val text: String)
}
