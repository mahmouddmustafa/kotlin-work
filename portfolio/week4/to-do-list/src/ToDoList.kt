// COMP2850 Portfolio: Week 4
// ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size
    val notStarted: Int  // compute no. of items with NotStarted status
        get() = items.count{
            it.status == ItemStatus.NotStarted
        }
    val inProgress: Int   // compute no. of items with InProgress status
        get() = items.count{
            it.status == ItemStatus.InProgress
        }
    val done: Int         // compute no. of items with Done status
        get() = items.count{
            it.status == ItemStatus.Done
        }
    val overdue: Int      // compute no. of overdue items
        get() = items.count{
            it.isOverdue()
        }

    // count() goes through the list and counts how many items meet the condition

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {
        // Implement code to read To Do list from a file here
        // See data/to-do.csv for an example of the format
        // Clears existing items before loading the file
        items.clear()

        // Reads file one line at a time
        Path(filename).forEachLine{
            line -> 

            // Splits each line usinh :
            val part = line.split(": ", limit = 3)

            // Extracts status date and descripton
            val dueDate = LocalDate.parse(part[0])
            val status = ItemStatus.valueOf(part[1])
            val description = part[2]

            // Creates a To-do-item and add to the list
            items.add(ToDoItem(dueDate, status, description))
        }
    }
    fun save(filename: String) {

        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        // Write code here to remove items with status of Done
        // Return true if any were removed, false if none were removed
        return items.removeAll{
            it.status == ItemStatus.Done
        }
        // removeAll() removes every completed item resulting in True if anything was removed and False  if not
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {
        // Write code here to return a list of items with the matching
        // status, or a list of all items if status argument is null
        return if (status == null){
            items
        } else{
            items.filter{
                it.status == status
            }
        }
        // retursn all items if the status is null, or filter by requested status otherwise
    }

    fun getItemsDueOn(date: LocalDate): List<ToDoItem> {
        // Write code here to return a list of items
        // that are due on the specified date
        return items.filter{
            it.dueDate == date
        }
        // filters items using the due date
    }
}
