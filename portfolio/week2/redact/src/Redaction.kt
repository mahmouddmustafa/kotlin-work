// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

// Replacing every occurence of the text with a redaction char
fun redact(doc: String, txt: String, char: Char = 'X'): String {
    // Replace target text with the same no. of refaction chars
    return doc.replace(txt, char.toString().repeat(txt.length))
}