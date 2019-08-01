package com.example.listitemstring;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

class CustomListAdapter extends BaseAdapter {

        private List<Country> listData;
        private LayoutInflater layoutInflater;
        private Context context;

  public CustomListAdapter(Context aContext,  List<Country> listData) {
            this.context = aContext;
            this.listData = listData;
            layoutInflater = LayoutInflater.from(aContext);
        }

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.customlayoutitem, null);
                holder = new ViewHolder();
                holder.flagView = (ImageView) convertView.findViewById(R.id.imageView_flag);
                holder.countryNameView = (TextView) convertView.findViewById(R.id.textView_countryName);
                holder.populationView = (TextView) convertView.findViewById(R.id.textView_population);
                holder.textViewPosition = (TextView) convertView.findViewById(R.id.textViewPosition);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = this.listData.get(position);
            holder.countryNameView.setText(country.getCountryName());
            holder.populationView.setText("Population: " + country.getPopulation());

            int imageId = this.getMipmapResIdByName(country.getFlagName());

            holder.flagView.setImageResource(imageId);
            holder.textViewPosition.setText(String.valueOf(position));
            return convertView;
        }

        // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
        static class ViewHolder {
            ImageView flagView;
            TextView countryNameView;
            TextView populationView;
            TextView textViewPosition;
        }

}
