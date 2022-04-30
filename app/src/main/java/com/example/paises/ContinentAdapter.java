package com.example.paises;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;


class ContinentAdapter extends ArrayAdapter<Flag> {
        private CountryData instance= CountryData.getInstance();
        private int counter=0;
        private static class ViewHolder {
            ImageView iconoImagen;
            TextView title;
        }

        public ContinentAdapter(Context context, ArrayList<Flag> pics){
            super(context,-1,pics);


        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Flag item= (Flag) getItem(position);
            ViewHolder viewHolder;
            if(convertView==null) {

                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.cell, parent, false);
                viewHolder.iconoImagen = (ImageView) convertView.findViewById(R.id.thumbV);
                viewHolder.title = (TextView) convertView.findViewById(R.id.titleV);
                convertView.setTag(viewHolder);
            }
            else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            convertView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });
            try {
                if(item.getTitle().contains("Continent") || item.getimageUrl().contains("Continent")|| instance.getdataPic().contains(item)) {
                    Drawable d = Drawable.createFromStream(this.getContext().getAssets().open(item.getimageUrl()), null);
                    viewHolder.iconoImagen.setImageDrawable(d);
                    viewHolder.title.append(item.getTitle());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return convertView;


        }}
        /*private class LoadImageTask extends AsyncTask<String,Void, Bitmap> {
            private ImageView imageView;
            public LoadImageTask(ImageView imageView)
            {
                this.imageView=imageView;
            }



            @Override
            protected Bitmap doInBackground(String... params) {
                Bitmap bitmap = null;
                HttpURLConnection connection = null;

                try {
                    URL url = new URL(params[0]);
                    connection = (HttpURLConnection) url.openConnection();

                    try (InputStream inputStream = connection.getInputStream()) {
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        instance.addtoCache(params[0], bitmap);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    connection.disconnect();
                }

                return bitmap;
            }
            @Override
            protected void onPostExecute(Bitmap bitmap){imageView.setImageBitmap(bitmap);}
        }*?
}
*/
