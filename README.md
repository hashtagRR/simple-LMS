# simple-LMS

A desktop Library Management System built as a Java Swing application
(NetBeans project) backed by a MySQL database via JDBC. No particular
OOP design or security was a goal here — the point of the project was
implementing the internal functions a library system needs (borrowing,
returns, reservations, fines, etc.), not code architecture.

This is a coursework/learning project, not production software.

## What it does

`src/gui/Login.java` checks the entered username/password against both an
`admin` table and a `member` table (plain, unhashed SQL queries) and routes
to one of two home screens:

- **Admin home** (`Home.java`) provides access to:
  - Register Member / Edit-Search Member (`Register_member.java`,
    `Edit_member.java`)
  - View Fines (`View_fines.java`)
  - Register Book / Edit Book / Search Book (`Register_book.java`,
    `Edit_book.java`, `Search_books.java`)
  - Admin accounts (`Admin_manage.java`)
  - Overdues (`Overdues.java`)
  - Recover Accounts (`Recover_accounts.java`)
  - Borrow / Return (`Loan.java`, `Return.java`)
  - Make Reservation / Claim-View Reservation (`Reservation.java`,
    `Claim_view_reservations.java`)
- **Member home** (`Member_Home.java`) provides access to:
  - Reserve Book (`Member_Reservation.java`)
  - Search Books (`Member_Search_books.java`)
  - Change Password (`Member_Change_password.java`)

`src/DB_con/SQLCON.java` opens the JDBC connection (hardcoded to
`jdbc:mysql://localhost:3306/library_db`, user `root`, password `1234`) —
update this if your local MySQL credentials differ. No `.sql` schema file
is included in the repo; the required tables (`admin`, `member`, and
whatever backs books/loans/reservations/fines) are inferred from the
queries in `src/gui/*.java` but not shipped as a dump.

## Project layout

- `build.xml` — Ant build script (NetBeans-generated; imports
  `nbproject/build-impl.xml`), the real way to build this project.
- `nbproject/` — NetBeans project metadata used by the Ant build.
- `manifest.mf` — JAR manifest stub (NetBeans fills in `Main-Class` at
  build time).
- `src/DB_con/SQLCON.java` — the single JDBC connection helper.
- `src/gui/` — all Swing forms (`.java` + matching NetBeans `.form` files)
  and icons used by the UI.
- `build.zip` — a zipped copy of a previous Ant build output, checked into
  the repo; it is not needed to build the project (Ant regenerates
  `build/` and `dist/` from source) and is left as-is here since this pass
  is documentation-only.

## Running it

1. Install a JDK, Apache Ant, and MySQL (a MySQL Connector/J JAR needs to
   be on the classpath — NetBeans normally manages this via the project's
   library references in `nbproject/project.properties`).
2. Create a `library_db` MySQL database with the tables the code expects
   (`admin`, `member`, plus book/loan/reservation/fine tables — no schema
   dump is included, so these need to be created by hand based on the
   queries in `src/gui/`).
3. Update the connection details in `src/DB_con/SQLCON.java` if your MySQL
   setup differs from `root`/`1234`/`localhost:3306`.
4. Build and run:
   - With NetBeans: open the project folder and use Run.
   - From the command line: `ant jar` (uses `build.xml`) then run the
     resulting JAR from `dist/`, e.g. `java -jar dist/LMS.jar`.
