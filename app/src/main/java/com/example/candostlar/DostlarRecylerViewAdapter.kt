package com.example.candostlar


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_uye.view.*

class DostlarRecylerViewAdapter(tumDostlar:ArrayList<Dost>): RecyclerView.Adapter<DostlarRecylerViewAdapter.DostViewHolder>() {
    var dostlar=tumDostlar

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DostViewHolder {
        var inflater=LayoutInflater.from(parent.context)
        var tek_uye=inflater.inflate(R.layout.tek_uye,parent,false)

        return DostViewHolder(tek_uye)
    }

    override fun getItemCount(): Int {
        return dostlar.size
    }

    override fun onBindViewHolder(holder: DostViewHolder, position: Int) {
        var oanOlusturulanDost=dostlar.get(position)
        holder.setData(oanOlusturulanDost,position)
    }


    class DostViewHolder(tek_uye: View) : RecyclerView.ViewHolder(tek_uye) {
        fun setData(oanOlusturulanDost: Dost, position: Int) {

            dostAdi.text=oanOlusturulanDost.isim
            dostResim.setImageResource(oanOlusturulanDost.resim)

            tekDostBilgisi.setOnClickListener {
                Toast.makeText(tekDostBilgisi.context,"Tıklanılan Öğe:"+position+"Adı:"+oanOlusturulanDost.isim,Toast.LENGTH_SHORT).show()
                tekDostBilgisi.isClickable=false

            }

        }

        var tekDostBilgisi=tek_uye as CardView
        var dostAdi=tekDostBilgisi.txtDostAdi
        var dostResim=tekDostBilgisi.imgDost

    }

    fun setFilter(aranılanlar:ArrayList<Dost>){
        dostlar=ArrayList<Dost>()
        dostlar.addAll(aranılanlar)
        notifyDataSetChanged()

    }
}