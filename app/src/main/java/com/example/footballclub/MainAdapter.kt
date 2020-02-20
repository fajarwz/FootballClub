package com.example.footballclub

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*


/*
    Created by: fajar on 21/11/19.
*/

//TeamViewHolder mewarisi kelas RecyclerView.ViewHolder. Kelas ini akan dijadikan parameter
//untuk kelas RecyclerView.Adapter yang diwariskan ke kelas MainAdapter

class MainAdapter (private val teams: List<Team>) : RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    //definisikan teams.size sebagai nilainya
    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        //menampilkan data pada posisi yang telah ditentukan
        holder.bindItem(teams[position])
    }
}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view){
    //deklarasikan semua view di TeamViewHolder ini
    private val teamBadge: ImageView = view.find(R.id.team_badge)
    private val teamName: TextView = view.find(R.id.team_name)

    //mengumpulkan objek dari data class ke masing-masing view
    fun bindItem(teams: Team){
        Picasso.get().load(teams.teamBadge).fit().into(teamBadge)
        teamName.text = teams.teamName
    }
    //tampilan yg sudah didesain sekarang akan ditampilkan saat method onCreateViewHolder dijalankan
}


class TeamUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.team_badge    //definisikan dahulu id ke id value resource. ini bisa ditemui di ids.xml
                }.lparams{
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.team_name
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }
            }
        }
    }
}

