import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 2;
        private static final String DATABASE_NAME = "estoqueFarma.db";

        public static final String TABLE_PRODUTOS = "produtos";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_CATEGORIA = "categoria";
        public static final String COLUMN_PRECO = "preco";
        public static final String COLUMN_QUANTIDADE = "quantidade";
        public static final String COLUMN_DATA_VALIDADE = "data_validade";

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE_PRODUTOS = "CREATE TABLE " + TABLE_PRODUTOS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOME + " TEXT,"
                    + COLUMN_CATEGORIA + " TEXT,"
                    + COLUMN_PRECO + " REAL,"
                    + COLUMN_QUANTIDADE + " INTEGER,"
                    + COLUMN_DATA_VALIDADE + " TEXT"
                    + ")";
            db.execSQL(CREATE_TABLE_PRODUTOS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion == 1 && newVersion == 2) {
                db.execSQL("ALTER TABLE " + TABLE_PRODUTOS + " ADD COLUMN data_validade TEXT");
            }
        }

    }

