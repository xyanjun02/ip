# Bob Chatbot User Guide

Welcome to **Bob**, your friendly task management chatbot! Bob helps you keep track of your tasks with ease. This guide will provide you with all the information you need to use Bob's features effectively.

---

## 🚀 Quick Start

1. **Ensure Java is installed** on your computer.
2. **Download** the latest version of `Bob.jar` from [GitHub Releases](https://github.com/yourusername/bob/releases).
3. **Run Bob** from the terminal with the following command:

```bash
java -jar Bob.jar
```

4. You should see a welcome message. You can start entering commands to manage your tasks!

---

## ✨ Features

### 📝 Adding Tasks

Bob supports three types of tasks:

#### 1. Todo
Adds a simple task without a date.

**Format:**
```bash
todo TASK_DESCRIPTION
```

**Example:**
```bash
todo read book
```

💡 **Tip:** Use clear and concise descriptions for better task management.

#### 2. Deadline
Adds a task with a specific due date.

**Format:**
```bash
deadline TASK_DESCRIPTION /by DUE_DATE
```

**Example:**
```bash
deadline return book /by June 6th
```

#### 3. Event
Adds a task that occurs during a specific period.

**Format:**
```bash
event TASK_DESCRIPTION /from START_TIME /to END_TIME
```

**Example:**
```bash
event project meeting /from 2pm /to 4pm
```

---

### 📋 Listing All Tasks
Displays all tasks in your list.

**Command:**
```bash
list
```

---

### ✅ Marking Tasks as Done
Marks a task as completed.

**Command:**
```bash
mark TASK_NUMBER
```

**Example:**
```bash
mark 1
```

---

### ❌ Unmarking Tasks
Marks a task as not completed.

**Command:**
```bash
unmark TASK_NUMBER
```

**Example:**
```bash
unmark 1
```

---

### 🗑️ Deleting Tasks
Removes a task from your list.

**Command:**
```bash
delete TASK_NUMBER
```

**Example:**
```bash
delete 1
```

---

### 🔍 Finding Tasks by Keyword
Searches for tasks containing a specific keyword.

**Command:**
```bash
find KEYWORD
```

**Example:**
```bash
find book
```

---

### 🚪 Exiting the Application
Closes Bob with a friendly message.

**Command:**
```bash
bye
```

---

## 💾 Saving Data
Bob automatically saves your tasks to a file after any changes. Your data will be loaded automatically when you start Bob again.

---

## 🛠️ Troubleshooting
- **Invalid Input:** If you enter an unrecognized command, Bob will prompt you with a helpful message.
- **Out of Range:** If a task number is invalid, Bob will let you know.







