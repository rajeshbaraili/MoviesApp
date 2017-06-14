package com.example.rajesh.moviesapp.PojoClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by rajesh on 6/9/2017.
 */

public class NowshowingPoJo implements Parcelable {



    private int page;
    private int total_results;
    private DatesBean dates;
    private int total_pages;
    private List<ResultsBean> results;


    protected NowshowingPoJo(Parcel in) {
        page = in.readInt();
        total_results = in.readInt();
        dates = in.readParcelable(DatesBean.class.getClassLoader());
        total_pages = in.readInt();
        results = in.createTypedArrayList(ResultsBean.CREATOR);
    }

    public static final Creator<NowshowingPoJo> CREATOR = new Creator<NowshowingPoJo>() {
        @Override
        public NowshowingPoJo createFromParcel(Parcel in) {
            return new NowshowingPoJo(in);
        }

        @Override
        public NowshowingPoJo[] newArray(int size) {
            return new NowshowingPoJo[size];
        }
    };

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public DatesBean getDates() {
        return dates;
    }

    public void setDates(DatesBean dates) {
        this.dates = dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(total_results);
        dest.writeParcelable(dates, flags);
        dest.writeInt(total_pages);
        dest.writeTypedList(results);
    }


    public static class DatesBean  implements  Parcelable{

        private String maximum;
        private String minimum;

        protected DatesBean(Parcel in) {
            maximum = in.readString();
            minimum = in.readString();
        }

        public static final Creator<DatesBean> CREATOR = new Creator<DatesBean>() {
            @Override
            public DatesBean createFromParcel(Parcel in) {
                return new DatesBean(in);
            }

            @Override
            public DatesBean[] newArray(int size) {
                return new DatesBean[size];
            }
        };

        public String getMaximum() {
            return maximum;
        }

        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(maximum);
            dest.writeString(minimum);
        }
    }

    public static class ResultsBean  implements Parcelable {


        private int vote_count;
        private int id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;

        protected ResultsBean(Parcel in) {
            vote_count = in.readInt();
            id = in.readInt();
            video = in.readByte() != 0;
            vote_average = in.readDouble();
            title = in.readString();
            popularity = in.readDouble();
            poster_path = in.readString();
            original_language = in.readString();
            original_title = in.readString();
            backdrop_path = in.readString();
            adult = in.readByte() != 0;
            overview = in.readString();
            release_date = in.readString();
        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel in) {
                return new ResultsBean(in);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(vote_count);
            dest.writeInt(id);
            dest.writeByte((byte) (video ? 1 : 0));
            dest.writeDouble(vote_average);
            dest.writeString(title);
            dest.writeDouble(popularity);
            dest.writeString(poster_path);
            dest.writeString(original_language);
            dest.writeString(original_title);
            dest.writeString(backdrop_path);
            dest.writeByte((byte) (adult ? 1 : 0));
            dest.writeString(overview);
            dest.writeString(release_date);
        }
    }
}

