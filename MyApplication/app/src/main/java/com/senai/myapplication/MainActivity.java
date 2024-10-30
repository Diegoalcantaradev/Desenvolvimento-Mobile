import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FarmáciaDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "farmacia.db";
    private static final int DATABASE_VERSION = 1;

    public FarmáciaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CLIENTE = "CREATE TABLE cliente (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "telefone TEXT," +
                "cpf TEXT)";

        String CREATE_TABLE_PEDIDO = "CREATE TABLE pedido (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "data TEXT," +
                "total REAL," +
                "fkProduto INTEGER," +
                "fkCliente INTEGER," +
                "FOREIGN KEY(fkProduto) REFERENCES produto(id)," +
                "FOREIGN KEY(fkCliente) REFERENCES cliente(id))";

        String CREATE_TABLE_PRODUTO = "CREATE TABLE produto (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "valorUnitario REAL)";

        db.execSQL(CREATE_TABLE_CLIENTE);
        db.execSQL(CREATE_TABLE_PEDIDO);
        db.execSQL(CREATE_TABLE_PRODUTO);
    }

    // métodos
    public long insertCliente(String nome, String telefone, String cpf) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("telefone", telefone);
        values.put("cpf",
                cpf);
        long id = db.insert("cliente", null, values);
        db.close();
        return id;
    }
}