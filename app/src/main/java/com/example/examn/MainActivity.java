package com.example.examn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    prueba  farmac;
    MyModel farma;
    MyAdapter Adapter;

    // agregamos ala lista el eventos que requiere para cargar el menu contextual
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView)findViewById(R.id.list1);
        myList.setOnCreateContextMenuListener(this);// evento para que la lista cargeue el menu contextual
        llenarLista();
    }
    //llenamos la lista con diferentes datos e imagenes
    void llenarLista(){
        farmac=new prueba();
        farma=new MyModel("Amoxicilina","tableta","200","C$ 15","San Ramon");
        farma.setImage(R.drawable.amogcilina);
        farmac.add(farma);

        farma=new MyModel("Azitromicina","tableta","150","C$ 212 ","Dextex");
        farma.setImage(R.drawable.azitromicina);
        farmac.add(farma);

        farma=new MyModel("Neurobion","tableta","100","C$ 10","Santafe");
        farma.setImage(R.drawable.neuro);
        farmac.add(farma);
        Adapter=new MyAdapter(this,R.layout.item_list,farmac);
        myList.setAdapter(Adapter);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones");
        getMenuInflater().inflate(R.menu.menucontextual, menu);// infla xml con los items

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {

            case R.id.bteliminar: // acciones para item delet del dialogo
                this.farmac.remove(info.position);// quita un elemento de la lista
                this.Adapter.notifyDataSetChanged();// actauliza el adaptador
                break;
            case R.id.btsalir:// acciones para el item btsalir del app
                this.finish();
                break;
            case R.id.btagregar:// acciones para tem btagregar del dialogo

                // el dialogo debe declararse de tipo final para ser reconocido
                //desde los eventos onClik de la actividad
                final Dialog dlg = new Dialog(this);// definir obejto del dialogo
                dlg.setContentView(R.layout.agregar_nuevo);// xml del dialogo
                dlg.setTitle("ASIGNATURA");
                dlg.setCancelable(false);//no se puede cerrar

                //referencaiando alos botones de dialogo
                Button buttonAgregar = (Button) dlg.findViewById(R.id.buttonAgregar);
                Button buttonCancelar = (Button) dlg.findViewById(R.id.buttonCancelar);

                // evento click del boton agregar nuevo
                buttonAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        EditText editText_nombremed = (EditText) dlg.findViewById(R.id.editTextnombremed);
                        EditText editText_presentacion = (EditText) dlg.findViewById(R.id.editTextpresentacion);
                        EditText editText_laboratorio = (EditText) dlg.findViewById(R.id.editTextlaboratorio);
                        EditText editText_precio = (EditText) dlg.findViewById(R.id.editTextprecio);
                        EditText editText_cantidad = (EditText) dlg.findViewById(R.id.editTextCantidad);

                        //comprobacion de que todos los campos esten llenos y ningunos esten vacios
                        if ((editText_nombremed.getText().toString().contentEquals(""))||(editText_presentacion.getText().toString().contentEquals(""))||
                                (editText_laboratorio.getText().toString().contentEquals(""))||(editText_precio.getText().toString().contentEquals(""))||(editText_cantidad.getText().toString().contentEquals(""))) {

                            Toast.makeText(MainActivity.this, "todos los campos deben estar llenados", Toast.LENGTH_LONG).show();

                        }else{

                            MyModel nuevoMedicamento = new MyModel();// creamos un objetos para para  cada unos de los campos edit_text

                            // se agrega ala lista los elementos
                            nuevoMedicamento.setNombreProduc(editText_nombremed.getText().toString());
                            nuevoMedicamento.setDescripcionProd(editText_presentacion.getText().toString());
                            nuevoMedicamento.setLaboratorio(editText_laboratorio.getText().toString());
                            nuevoMedicamento.setPrecio(editText_precio.getText().toString());
                            nuevoMedicamento.setImage(R.drawable.vitalfuerte);

                            nuevoMedicamento.setCantidad(editText_cantidad.getText().toString());

                            farmac.add(nuevoMedicamento);// agregamos ala lista el nuevo medicamento

                            Adapter.notifyDataSetChanged();// actualiza el adaptador

                            // para limpiar cada edit_text despues de agregar uno ala lista
                            editText_nombremed.setText("");
                            editText_presentacion.setText("");
                            editText_laboratorio.setText("");
                            editText_precio.setText("");
                            editText_cantidad.setText("");
                            dlg.cancel();//cierra el dialogo
                        }
                    }

                });
                // evento click cancelar
                buttonCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });
                dlg.show();// muestra el dialogo
                break;
        }

        return super.onContextItemSelected(item);
    }


}
