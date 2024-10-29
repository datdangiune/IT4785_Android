import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.Email
import com.example.gmail.R

class EmailAdapter(private val emailList: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sender: TextView = view.findViewById(R.id.textViewSender)
        val title: TextView = view.findViewById(R.id.textViewTitle)
        val snippet: TextView = view.findViewById(R.id.textViewSnippet)
        val time: TextView = view.findViewById(R.id.textViewTime)
        val initial: TextView = view.findViewById(R.id.textViewInitial)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.sender.text = email.sender
        holder.title.text = email.title
        holder.snippet.text = email.snippet
        holder.time.text = email.time
        holder.initial.text = email.sender.first().toString()
    }

    override fun getItemCount() = emailList.size
}
