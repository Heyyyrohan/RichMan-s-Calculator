<h1>📱 RichMan's Calculator</h1>
<p>A <b>modern Android calculator app</b> built with <b>Jetpack Compose</b> and <b>Material 3</b>.</p>
<p>It supports basic arithmetic operations, parentheses, power calculation, and handles operator precedence using <b>Infix → Postfix conversion</b> with evaluation logic implemented in Kotlin.</p>

<h2>✨ Features</h2>
<ul>
  <li>🖥 <b>Modern UI</b> – Built entirely with <b>Jetpack Compose</b>.</li>
  <li>➕ <b>Basic Operations</b> – Addition, subtraction, multiplication, division.</li>
  <li>📐 <b>Advanced Operations</b> – Parentheses <code>()</code>.</li>
  <li>📏 <b>Operator Precedence</b> – Evaluates expressions correctly using <b>postfix evaluation</b>.</li>
  <li>♻ <b>AC &amp; DEL Buttons</b> – Clear all or delete the last character.</li>
  <li>🎨 <b>Custom Colors &amp; Layout</b> – Clean and minimal UI design.</li>
</ul>

<h2>📸 Screenshots</h2>
<img width="270" height="570" alt="CalcSS01" src="https://github.com/user-attachments/assets/40120e36-26f1-4826-819d-0bdc67041743" />
<img width="270" height="570" alt="CalcSS02" src="https://github.com/user-attachments/assets/021d5594-db23-4c64-99cb-d85e5061ffc9" />


<h2>🛠 Tech Stack</h2>
<ul>
  <li><b>Language:</b> Kotlin</li>
  <li><b>UI Framework:</b> Jetpack Compose</li>
  <li><b>Material Design:</b> Material 3 Components</li>
  <li><b>Architecture:</b> Simple state management with <code>remember</code> and <code>mutableStateOf</code></li>
  <li><b>Algorithm:</b> Infix to Postfix conversion + Postfix evaluation using <code>Stack</code></li>
</ul>

<h2>⚙️ How It Works</h2>
<ol>
  <li><b>UI Layer (Jetpack Compose)</b>
    <ul>
      <li>Dynamically renders a grid of buttons.</li>
      <li>Handles click events for input, delete, clear, and evaluation.</li>
    </ul>
  </li>
  <li><b>Logic Layer (Kotlin)</b>
    <ul>
      <li><b>Infix to Postfix Conversion:</b> Uses a stack to convert infix expressions into postfix format, respecting operator precedence and parentheses.</li>
      <li><b>Postfix Evaluation:</b> Uses a stack to evaluate the postfix expression and produce the final result.</li>
    </ul>
  </li>
</ol>

<h2>📂 Project Structure</h2>
<code>📦 com.example.richmanscalculator<br>
 ├── MainActivity.kt         <br>
 ├── CalculatorScreen.kt    # Main UI & Calculator layout
 ├── CalculatorViewModel.kt   # Core math logic (infix to postfix + evaluation)
</code>

<h2>🚀 Getting Started</h2>
<h3>1️⃣ Clone the repository</h3>
<code>git clone https://github.com/Heyyyrohan/RichMan-s-Calculator</code>

<h3>2️⃣ Open in Android Studio</h3>
<ul>
  <li>Open the project in <b>Android Studio</b> (Giraffe or newer recommended).</li>
  <li>Let Gradle sync automatically.</li>
</ul>

<h3>3️⃣ Run the App</h3>
<ul>
  <li>Select an Android device or emulator.</li>
  <li>Click <b>Run ▶</b>.</li>
</ul>

<h2>🔢 Example</h2>
<p><b>Input:</b></p>
<code>(2+3)*4*4</code>
<p><b>Steps:</b></p>
<ul>
  <li>Infix → Postfix: <code>2 3 + 4 4 * *</code></li>
  <li>Evaluate: <code>80</code></li>
</ul>
<p><b>Output:</b></p>
<code>80</code>

<h2>🏆 The Story Behind <i>RichMan's Calculator</i></h2>
<p>The name comes from a friendly challenge. One of my friends built a console calculator in C++ and called it <i>"Poor Man's Calculator"</i> because it had no UI just plain text in the console.
It worked perfectly, but I told him:
"Even if it works well, without a nice UI it looks boring."
He challenged me to make a calculator with an <b>attractive UI</b>.
So, I built this <b>Jetpack Compose</b> version clean, colorful, and user-friendly.
Since it was the “opposite” of his console version, I named it <b>RichMan's Calculator</b>.</p>

<h2>📜 License</h2>
<p>This project is licensed under the <b>MIT License</b>  you can freely use and modify it.</p>
