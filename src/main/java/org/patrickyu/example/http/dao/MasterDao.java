package org.patrickyu.example.http.dao;

import java.util.ArrayList;
import java.util.List;

import org.patrickyu.example.http.common.MyPreparedHandler;
import org.patrickyu.example.http.domain.Game;
import org.patrickyu.vertx.daohandler.ListDaoHandler;
import org.patrickyu.vertx.daohandler.ObjectDaoHandler;
import org.patrickyu.vertx.pgmysql.ResultSet;
import org.patrickyu.vertx.pgmysql.vo.PreparedSQL;

public class MasterDao extends BaseDao {

	public void getGameList(final ListDaoHandler<Game> handler) {
		PreparedSQL sql = new PreparedSQL("select * from game", new String[] {});
		pg.execute(sql, new MyPreparedHandler(handler) {
			@Override
			public void onSuccess(int affectedRows, ResultSet resultSet) {
				List<Game> list = new ArrayList<Game>();
				while( resultSet.next() ) {
					Game game = resultSet.currentRecordToObject(Game.class);
					list.add(game);
				}
				handler.onSuccess(list);
			}
		});
	}

//	public void getGame(String gameId, final ObjectHandler<Game> handler) {
//		PreparedSQL sql = new PreparedSQL("select * from game where id=?", new String[] {gameId});
//		pg.execute(sql, new MyPreparedHandler() {
//			@Override
//			public void onSuccess(int affectedRows, ResultSet resultSet) {
//				if (!resultSet.next()) {
//					handler.onSuccess(null);
//					return;
//				}
//				Game game = resultSet.currentRecordToObject(Game.class);
//				handler.onSuccess(game);
//			}
//			@Override
//			public void onError(String message, String error) {
//				//TODO 다국어
//				handler.onError(Constants.status.DB_ERROR, "데이터베이스 오류로 작업이 중단되었습니다.");
//			}
//		});
//
//	}

	public void getGame(String gameId, final ObjectDaoHandler<Game> handler) {
		PreparedSQL sql = new PreparedSQL("select * from game where id=?", new String[] {gameId});
		pg.execute(sql, new MyPreparedHandler(handler) {
			@Override
			public void onSuccess(int affectedRows, ResultSet resultSet) {
				Game game = null;
				if (resultSet.next()) {
					game = resultSet.currentRecordToObject(Game.class);
				}
				handler.onSuccess(game);
			}
		});
	}

//	public void confirmPayment(String coupon, final ObjectHandler<Integer> handler) {
//		PreparedSQL sql = new PreparedSQL(
//				" update tmp_payment set status = 'used' where coupon_no = ? and status = 'ready'",
//				new String[] {coupon});
//		pg.execute(sql, new MyPreparedHandler() {
//			@Override
//			public void onSuccess(int affectedRows, ResultSet resultSet) {
//				handler.onSuccess(affectedRows);
//			}
//			@Override
//			public void onError(String message, String error) {
//				//TODO 다국어
//				handler.onError(Constants.status.DB_ERROR, "데이터베이스 오류로 작업이 중단되었습니다.");
//			}
//		});
//	}
}
