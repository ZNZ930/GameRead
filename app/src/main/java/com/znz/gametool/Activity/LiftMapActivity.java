package com.znz.gametool.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;

import com.znz.gametool.Activity.CHiRe.LaiWenShi;
import com.znz.gametool.Activity.CHiRe.LaiWenShiLiMingQu;
import com.znz.gametool.Activity.CHiRe.ShengLuoNaShi;
import com.znz.gametool.Activity.FengBao.LaiXinGang;
import com.znz.gametool.Activity.FengBao.LaoLunSiWan;
import com.znz.gametool.Activity.FengBao.MiSiKaZhen;
import com.znz.gametool.Activity.FengBao.ShengPaTuoNi;
import com.znz.gametool.Activity.HuangSha.CanYuanGeBi;
import com.znz.gametool.Activity.HuangSha.ChenJiPingYuan;
import com.znz.gametool.Activity.HuangSha.HuangTuKuangYe;
import com.znz.gametool.Activity.HuangSha.ShaShiBao;
import com.znz.gametool.Activity.HuangZhao.DaHeQu;
import com.znz.gametool.Activity.HuangZhao.MaoSiXiaoZhen;
import com.znz.gametool.Activity.HuangZhao.MaoSiZhaoZe;
import com.znz.gametool.Activity.HuangZhao.ZhaoZeBianJing;
import com.znz.gametool.Activity.KuangYe.GuiYingShan;
import com.znz.gametool.Activity.KuangYe.HongShanZhen;
import com.znz.gametool.Activity.KuangYe.HongShuiHu;
import com.znz.gametool.Activity.KuangYe.HuiXiongShan;
import com.znz.gametool.Activity.OZOShangHui.QingKongMaiTIan;
import com.znz.gametool.Activity.OZOShangHui.QiuRiSenLin;
import com.znz.gametool.Activity.OZOShangHui.XiaYuGongLu;
import com.znz.gametool.Activity.XiaEr.HeiZhenZhuQu;
import com.znz.gametool.Activity.XiaEr.ShouLangYe;
import com.znz.gametool.Activity.XiaEr.ShuangLuShi;
import com.znz.gametool.Activity.XiaEr.YaShuCaoTan;
import com.znz.gametool.Activity.XiaEr.YaShuQiuLing;
import com.znz.gametool.Activity.XueYuan.BaiShuGaoDi;
import com.znz.gametool.Activity.XueYuan.DuoBeiXueShan;
import com.znz.gametool.Activity.XueYuan.JiDiBingYuan;
import com.znz.gametool.Activity.XueYuan.ShengDanCun;
import com.znz.gametool.Activity.XueYuan.WeiNaXueChang;
import com.znz.gametool.Activity.XueYuan.WuCiKuangChang;
import com.znz.gametool.Activity.XueYuan.XingHeXiaGu;
import com.znz.gametool.AllBean.MapGlistBean;
import com.znz.gametool.AllBean.MapNlistBean;
import com.znz.gametool.R;
import com.znz.gametool.ViewGroup.MapExlaBaseApdate;

import java.util.ArrayList;

public class LiftMapActivity extends AppCompatActivity {

    private MapExlaBaseApdate mrba;
    private ArrayList<MapGlistBean> Glist;
    private ArrayList<ArrayList<MapNlistBean>> Clist;
    private ArrayList<MapNlistBean> mapNlistBeans;
    private Context mContext;
    private ExpandableListView expand_map;
    private TextView read;
    //地图名称 数组
    public String Ditu [] = new String[]{"⑨圣诞村","③白树高地","③多贝雪山","③极地冰原","③星河峡谷","③乌茨矿场","⑨维纳雪场",
            "⑦沙石堡","⑦残垣戈壁","⑦沉寂平原", "⑦荒土旷野",
            "⑤莱辛港","⑤劳伦斯湾","⑤密斯卡镇","⑤圣托帕尼",
            "④大河区","⑥茅斯小镇","⑥茅斯沼泽","⑥沼泽边境",
            "⑤鬼影山","⑤红杉镇","⑨红水湖","⑨灰熊山",
            "莱文市","圣罗纳市","莱文市黎明区",
            "④狩狼野","⑤双路市","②亚述丘陵","②亚述草滩","④黑珍珠区",
            "①秋日森林","①晴空麦田","①夏雨公路"
    };
    //雪原庇护城
    //Intent 数组
    public Intent Dituintent [] = new Intent[]{getIntent(ShengDanCun.class), getIntent(BaiShuGaoDi.class), getIntent(DuoBeiXueShan.class), getIntent(JiDiBingYuan.class), getIntent(XingHeXiaGu.class),
            getIntent(WuCiKuangChang.class), getIntent(WeiNaXueChang.class), getIntent(ShaShiBao.class), getIntent(CanYuanGeBi.class), getIntent(ChenJiPingYuan.class), getIntent(HuangTuKuangYe.class),
            getIntent(LaiXinGang.class), getIntent(LaoLunSiWan.class), getIntent(MiSiKaZhen.class), getIntent(ShengPaTuoNi.class), getIntent(DaHeQu.class), getIntent(MaoSiXiaoZhen.class), getIntent(MaoSiZhaoZe.class), getIntent(ZhaoZeBianJing.class),
            getIntent(GuiYingShan.class), getIntent(HongShanZhen.class), getIntent(HongShuiHu.class), getIntent(HuiXiongShan.class), getIntent(LaiWenShi.class), getIntent(ShengLuoNaShi.class),
            getIntent(LaiWenShiLiMingQu.class), getIntent(ShouLangYe.class), getIntent(ShuangLuShi.class),getIntent(YaShuQiuLing.class), getIntent(YaShuCaoTan.class), getIntent(HeiZhenZhuQu.class), getIntent(QiuRiSenLin.class), getIntent(QingKongMaiTIan.class), getIntent(XiaYuGongLu.class),};
    //Class
    private Class c [] = new Class[]{ShengDanCun.class,
            BaiShuGaoDi.class,
            DuoBeiXueShan.class,
            JiDiBingYuan.class,
            XingHeXiaGu.class,
            WuCiKuangChang.class,
            WeiNaXueChang.class,
            ShaShiBao.class,
            CanYuanGeBi.class,
            ChenJiPingYuan.class,
            HuangTuKuangYe.class,
            LaiXinGang.class,
            LaoLunSiWan.class,
            MiSiKaZhen.class,
            ShengPaTuoNi.class,
            DaHeQu.class,
            MaoSiXiaoZhen.class,
            MaoSiZhaoZe.class,
            ZhaoZeBianJing.class,
            GuiYingShan.class,
            HongShanZhen.class,
            HongShuiHu.class,
            HuiXiongShan.class,
            LaiWenShi.class,
            ShengLuoNaShi.class,
            LaiWenShiLiMingQu.class,
            ShouLangYe.class,
            ShuangLuShi.class,
            YaShuQiuLing.class,
            YaShuCaoTan.class,
            HeiZhenZhuQu.class,
            QiuRiSenLin.class,
            QingKongMaiTIan.class,
            XiaYuGongLu.class,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_list);
        initView();
    }

    private void initView() {
        mContext = LiftMapActivity.this;
        AddMapGName();
        AddMapCName();
        expand_map = (ExpandableListView) findViewById(R.id.expand_map);
        mrba = new MapExlaBaseApdate(Glist, Clist, mContext);
        expand_map.setAdapter(mrba);
        read = (TextView) findViewById(R.id.read);
        ReadPihuc();
        ClickEpApadate();
    }

    //添加组 G 数据  Gson
    private void AddMapGName() {
        Glist = new ArrayList<MapGlistBean>();
        Clist = new ArrayList<ArrayList<MapNlistBean>>();
        Glist.add(new MapGlistBean("雪原庇护城"));
        Glist.add(new MapGlistBean("黄沙庇护城"));
        Glist.add(new MapGlistBean("风暴庇护城"));
        Glist.add(new MapGlistBean("荒沼庇护城"));
        Glist.add(new MapGlistBean("旷野庇护城"));
        Glist.add(new MapGlistBean("炽热庇护城"));
        Glist.add(new MapGlistBean("夏尔庇护城"));
        Glist.add(new MapGlistBean("101商会"));
    }

    //添加子 C 数据  Gson
    private void AddMapCName() {
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("⑨圣诞村"));
        mapNlistBeans.add(new MapNlistBean("③白树高地"));
        mapNlistBeans.add(new MapNlistBean("③多贝雪山"));
        mapNlistBeans.add(new MapNlistBean("③极地冰原"));
        mapNlistBeans.add(new MapNlistBean("③星河峡谷"));
        mapNlistBeans.add(new MapNlistBean("③乌茨矿场"));
        mapNlistBeans.add(new MapNlistBean("⑨维纳雪场"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("⑦沙石堡"));
        mapNlistBeans.add(new MapNlistBean("⑦残垣戈壁"));
        mapNlistBeans.add(new MapNlistBean("⑦沉寂平原"));
        mapNlistBeans.add(new MapNlistBean("⑦荒土旷野"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("⑤莱辛港"));
        mapNlistBeans.add(new MapNlistBean("⑤劳伦斯湾"));
        mapNlistBeans.add(new MapNlistBean("⑤密斯卡镇"));
        mapNlistBeans.add(new MapNlistBean("⑤圣托帕尼"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("④大河区"));
        mapNlistBeans.add(new MapNlistBean("⑥茅斯小镇"));
        mapNlistBeans.add(new MapNlistBean("⑥茅斯沼泽"));
        mapNlistBeans.add(new MapNlistBean("⑥沼泽边境"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("⑤鬼影山"));
        mapNlistBeans.add(new MapNlistBean("⑤红杉镇"));
        mapNlistBeans.add(new MapNlistBean("⑨红水湖"));
        mapNlistBeans.add(new MapNlistBean("⑨灰熊山"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("莱文市"));
        mapNlistBeans.add(new MapNlistBean("圣罗纳市"));
        mapNlistBeans.add(new MapNlistBean("莱文市黎明区"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("④狩狼野"));
        mapNlistBeans.add(new MapNlistBean("⑤双路市"));
        mapNlistBeans.add(new MapNlistBean("②亚述丘陵"));
        mapNlistBeans.add(new MapNlistBean("②亚述草滩"));
        mapNlistBeans.add(new MapNlistBean("④黑珍珠区"));
        Clist.add(mapNlistBeans);
        mapNlistBeans = new ArrayList<MapNlistBean>();
        mapNlistBeans.add(new MapNlistBean("①秋日森林"));
        mapNlistBeans.add(new MapNlistBean("①晴空麦田"));
        mapNlistBeans.add(new MapNlistBean("①夏雨公路"));
        Clist.add(mapNlistBeans);
    }

    //说明
    private void ReadPihuc() {
        read.setTextSize(15);
        read.setText("*该页面将地图按照庇护城名称进行划分\n" +
                "*序号①-⑨为地图资源等级\n" +
                "*部分地图未归属在庇护城里，已将个别地图添加到就近庇护城里\n" +
                "*①级地图归属到了101商会里\n" +
                "点击地图名称即可查看地图资源、\n" +
                "");
    }

    //点击事件
    private void ClickEpApadate(){
        expand_map.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    StartDituActivtity(groupPosition,childPosition);
                Log.i("TAA",""+c.length);
                return true;
            }
        });
    }

    private void ShwoMessage(String message)
    {
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }

    /*
    @getIntent(Class cs)
    获取Intent
     */
     public Intent getIntent(Class c)
    {
        Intent dituIntent = new Intent();
        return dituIntent;
    }

    //for循环遍历地图名字找到当前选中的地图  启动Activity
    public void StartDituActivtity(int group,int child)
    {
        int i =0;
        for ( i = 0;i<Ditu.length;i++)
        {
            if (Ditu[i].equals(Clist.get(group).get(child).getMapName()))
            {
                Dituintent[i].setClass(LiftMapActivity.this,c[i]);
                startActivity(Dituintent[i]);
            }
        }
    }

}
