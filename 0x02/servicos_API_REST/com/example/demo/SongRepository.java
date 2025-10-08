package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	private List<Song> list = new ArrayList<Song>();
	
	public SongRepository() {
		this.list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
		this.list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
	}

	public List<Song> getAllSongs() {
		return list;
	}

	public Song getSongById(Integer id) {
		for (Song song : list) {
			if (song.getId().equals(id)) {
				return song;
			}
		}
		return null;
	}

	public void addSong(Song s) {
		boolean contain = false;
		for (Song song : list) {
			if (song.getId().equals(s.getId())) {
				contain = true;
			}
		}
		if (!contain) {
			this.list.add(s);
		}
	}

	public void updateSong(Song s) {
		for (int i = 0; i < this.list.size(); i++) {
			Song song = this.list.get(i);
			if (song.getId().equals(s.getId())) {
				this.list.set(i, new Song(song.getId(), s.getNome(), s.getArtista(), s.getAlbum(), s.getAnoLancamento()));
			}
		}
	}

	public void removeSong(Song s) {
		for (Song song : list) {
			if (song.getId().equals(s.getId())) {
				this.list.remove(s);
			}
		}
	}

}
